package com.CultivaCursos.repository;

import com.CultivaCursos.model.ListaEspera;
import com.CultivaCursos.model.Course;
import com.CultivaCursos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {
    
    // Buscar todos os usuários em lista de espera para um curso específico
    List<ListaEspera> findByCurso(Course curso);
    
    // Verificar se um usuário já está na lista de espera de um curso
    boolean existsByCursoAndUsuario(Course curso, User usuario);
}
