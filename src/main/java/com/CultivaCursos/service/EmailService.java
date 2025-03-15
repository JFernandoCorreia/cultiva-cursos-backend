package com.CultivaCursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void enviarEmail(String to, String subject, String templateName, Context context) {
        try {
            logger.info("Preparando e-mail para: {}", to);

            // Processa o template Thymeleaf
            String body = templateEngine.process(templateName, context);

            // Cria a mensagem de e-mail
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // Define que o conteúdo é HTML

            mailSender.send(message);
            logger.info("E-mail enviado com sucesso para: {}", to);
            
        } catch (MessagingException e) {
            logger.error("Erro ao enviar e-mail para {}: {}", to, e.getMessage());
        } catch (MailException e) {
            logger.error("Falha na comunicação com o servidor SMTP: {}", e.getMessage());
        }
    }
}
