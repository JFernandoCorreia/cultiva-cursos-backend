package com.FlorDaCidade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FlorDaCidade.model.User;
import com.FlorDaCidade.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public User salvarUsuario(User usuario) {
        String senhaHash = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaHash);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<User> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostConstruct
    public void inicializarUsuarios() {
        if (usuarioRepository.findAll().isEmpty()) {
            // Criação de usuário comum
            User usuarioComum = new User();
            usuarioComum.setNome("João Silva");
            usuarioComum.setEmail("joaosilva@example.com");
            usuarioComum.setCpf("12345678901");
            usuarioComum.setPassword(passwordEncoder().encode("0123456"));  // Criptografando a senha
            usuarioRepository.save(usuarioComum);

            // Criação de funcionário
            User funcionario = new User();
            funcionario.setNome("João Silva Funcionario");
            funcionario.setEmail("joaosilva@example.rec.br");
            funcionario.setCpf("98765432100");
            funcionario.setPassword(passwordEncoder().encode("0123456"));  // Criptografando a senha
            usuarioRepository.save(funcionario);
        }
    }
}
