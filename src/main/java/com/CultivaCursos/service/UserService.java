package com.CultivaCursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CultivaCursos.model.User;
import com.CultivaCursos.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User salvarUsuario(User user) {
        // Verifica se o usuário já existe pelo CPF ou email
        if (userRepository.findByCpf(user.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Usuário com este CPF já existe.");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Usuário com este e-mail já existe.");
        }

        // Hash da senha antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @PostConstruct
    public void inicializarUsuarios() {
        if (userRepository.count() == 0) { // Verifica se há usuários antes de criar
            criarUsuario("João Silva", "joaosilva@example.com", "12345678901");
            criarUsuario("João Silva Funcionario", "joaosilva@example.rec.br", "98765432100");
        }
    }

    public User saveUser(User user) {
        return salvarUsuario(user);
    }

    private void criarUsuario(String nome, String email, String cpf) {
        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setCpf(cpf);
        user.setPassword(passwordEncoder.encode("0123456"));
        userRepository.save(user);
    }
}
