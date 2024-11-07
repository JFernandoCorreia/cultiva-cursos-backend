package com.FlorDaCidade.repository;

import com.FlorDaCidade.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpf(String cpf);
    User findByUsername(String username);
    
}
