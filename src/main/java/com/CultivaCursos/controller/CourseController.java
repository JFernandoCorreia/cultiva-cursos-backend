package com.CultivaCursos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.CultivaCursos.model.Course;
import com.CultivaCursos.model.ListaEspera;
import com.CultivaCursos.model.User;
import com.CultivaCursos.service.CourseService;
import com.CultivaCursos.service.EmailService;
import com.CultivaCursos.service.ListaEsperaService;
import com.CultivaCursos.service.SmsService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ListaEsperaService listaEsperaService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    private static final String CONFIRMACAO_INSCRICAO_TEMPLATE = "templates/confirmacao-inscricao.html";
    private static final String LISTA_ESPERA_TEMPLATE = "templates/lista-espera.html";

    @PostMapping("/{id}/inscrever")
    public ResponseEntity<?> inscreverUsuario(@PathVariable Long id, @RequestBody User user) {
        try {
            Optional<Course> optionalCurso = courseService.buscarCursoPorId(id);
            if (optionalCurso.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
            }

            Course curso = optionalCurso.get();

            if (curso.getVagas() > 0) {
                curso.setVagas(curso.getVagas() - 1);
                courseService.salvarCurso(curso);

                enviarNotificacoes(user, curso, CONFIRMACAO_INSCRICAO_TEMPLATE, "Inscrição confirmada");
                return ResponseEntity.ok("Inscrição confirmada");
            } else {
                ListaEspera listaEspera = new ListaEspera();
                listaEspera.setCurso(curso);
                listaEspera.setUsuario(user);
                listaEsperaService.adicionarAListaEspera(listaEspera);

                enviarNotificacoes(user, curso, LISTA_ESPERA_TEMPLATE, "Adicionado à lista de espera");
                return ResponseEntity.status(HttpStatus.CREATED).body("Adicionado à lista de espera");
            }

        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar notificação por e-mail.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao processar a inscrição.");
        }
    }

    private void enviarNotificacoes(User user, Course curso, String template, String mensagemSms) throws MessagingException {
        smsService.sendSms(user.getPhone(), mensagemSms + ": " + curso.getNome());

        Context context = new Context();
        context.setVariable("nome", user.getNome());
        context.setVariable("curso", curso.getNome());
        context.setVariable("data", curso.getDataLimiteInscricao());
        context.setVariable("local", curso.getLocal());

        emailService.enviarEmail(user.getEmail(), mensagemSms, template, context);
    }
}
