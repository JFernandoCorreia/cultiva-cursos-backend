package com.CultivaCursos.controller;

public class AuthRequest {
  private String email; // Use 'email' em vez de 'username'
  private String password;

  // Construtor
  public AuthRequest() {}

  // Getters
  public String getEmail() {
      return email;
  }

  public String getPassword() {
      return password;
  }

  // Setters
  public void setEmail(String email) {
      this.email = email;
  }

  public void setPassword(String password) {
      this.password = password;
  }

public Object getUsername() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
}
}