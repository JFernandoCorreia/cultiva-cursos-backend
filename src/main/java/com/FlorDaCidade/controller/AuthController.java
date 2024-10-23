package com.FlorDaCidade.controller;

import com.FlorDaCidade.model.User;
import com.FlorDaCidade.controller.AuthRequest;
import com.FlorDaCidade.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @SuppressWarnings("unused")
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) throws Exception {
        {
            try {
                Authentication authenticate = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    
                // Após a autenticação, obtenha o usuário logado
                User user = (User) authenticate.getPrincipal();
    
                // Gere o token JWT
                String jwt = jwtUtil.generateToken(user.getEmail());
                
                return ResponseEntity.ok(new Gson().toJson(new AuthenticationResponse(jwt)));
    
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Credenciais inválidas");
            }
    }
}

// Classe AuthRequest
    class AuthRequest {
        private String username;
        private String password;

        // Getters
        public String getUsername() {
            return username;
        }

        public Object getEmail() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
        }

        public String getPassword() {
            return password;
        }

        // Setters
        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
