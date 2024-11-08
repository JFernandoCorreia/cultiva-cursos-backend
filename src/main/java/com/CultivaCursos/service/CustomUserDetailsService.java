package com.CultivaCursos.service;

import com.CultivaCursos.model.User; // Certifique-se de que a classe User está importada corretamente
import com.CultivaCursos.repository.UserRepository; // Importar seu repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Repositório para buscar o usuário

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // Buscar usuário pelo nome de usuário
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // Retornar os detalhes do usuário
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
