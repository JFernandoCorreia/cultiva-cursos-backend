package com.FlorDaCidade.controller;

import com.FlorDaCidade.repository.UserRepository;

import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.MediaType;

@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureAfter
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @TestOnly
    public void testRegisterUser() throws Exception {
        String userJson = "{\"name\":\"João Silva\",\"cpf\":\"12345678900\",\"email\":\"joaosilva@example.com\",\"password\":\"0123456\"}";

    }
}
