package com.CultivaCursos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CultivaCursos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar um usuário pelo CPF
    Optional<User> findByCpf(String cpf);
    
    // Buscar um usuário pelo e-mail (corrigindo 'username')
    Optional<User> findByEmail(String email);
}
