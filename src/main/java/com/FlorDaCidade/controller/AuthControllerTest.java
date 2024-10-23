package com.FlorDaCidade.controller;

import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfiguration
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestOnly
    public void testLogin() throws Exception {
        @SuppressWarnings("unused")
        String authJson = "{\"username\":\"testUser\", \"password\":\"senha123\"}";
        mockMvc.perform(((Object) post("/login")
                .contentType(MediaType.APPLICATION_JSON)));
    }

    @SuppressWarnings("unused")
    private Object status() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'status'");
    }

    private MockMvc post(String string) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'post'");
    }
}
