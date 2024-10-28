package com.FlorDaCidade.controller;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import com.FlorDaCidade.model.Course;
import com.FlorDaCidade.service.CourseService;
import com.FlorDaCidade.util.JwtUtil;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @SuppressWarnings("unused")
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private CourseService cursoService;

    @Autowired
    private JwtUtil jwtUtil;

    @SuppressWarnings("unused")
    private String jwtToken;

    @Before(value = "")
    public void setUp() {
        // Gerar um token JWT de teste
        jwtToken = jwtUtil.generateToken("testUser");
    }

    @PostMapping("/criar")
    public Course criarCurso(@RequestBody Course curso) {
        return cursoService.salvarCurso(curso);
    }

    @GetMapping
    public List<Course> listarCursos() {
        return cursoService.listarCursos();
    }
}
