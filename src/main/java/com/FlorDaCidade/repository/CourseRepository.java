package com.FlorDaCidade.repository;

import com.FlorDaCidade.model.Course;
import com.FlorDaCidade.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    User findByUsername(String username); // Método para buscar usuário pelo nome de usuário
    
}
