package com.FlorDaCidade.security;

import com.FlorDaCidade.util.JwtUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Entity
    @Table(name = "usuarios")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String email;
        
                public String getEmail() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
                }
        
        }
        
                @Autowired
                private UserDetailsService userDetailsService;
        
                @Autowired
                private JwtUtil jwtUtil;
        
                @SuppressWarnings("null")
                @Override
                protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                    throws ServletException, IOException {
        
                    final String authorizationHeader = request.getHeader("Authorization");
        
                    String username = null;
                    String jwt = null;
        
                    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                        jwt = authorizationHeader.substring(7);
                        username = jwtUtil.extractUsername(jwt);
                    }
        
                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        
                        if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
                            User user = (User) userDetails;
                            if (jwtUtil.validateToken(jwt, user.getEmail())){ // Valida o token com o email do usuário
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            chain.doFilter(request, response);
        }
    }
}