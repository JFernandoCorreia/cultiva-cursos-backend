package com.CultivaCursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CultivaCursos.model.Course;
import com.CultivaCursos.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public Course cadastrarOuAtualizarCurso(Course curso) {
        return courseRepository.save(curso);
    }

    @Transactional(readOnly = true)
    public List<Course> listarCursos() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Course> buscarCursoPorId(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public void deletarCurso(Long id) {
        Optional<Course> curso = buscarCursoPorId(id); // Lança exceção se não encontrar
        courseRepository.delete(curso);
    }

    @Transactional
    public Course salvarCurso(Course curso) {
        return courseRepository.save(curso);
    }
}
