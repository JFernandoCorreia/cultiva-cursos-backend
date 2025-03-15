package com.CultivaCursos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CultivaCursos.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    // Método correto: Buscar curso pelo nome
    Course findByNome(String nome);

    public void delete(Optional<Course> curso);
}
