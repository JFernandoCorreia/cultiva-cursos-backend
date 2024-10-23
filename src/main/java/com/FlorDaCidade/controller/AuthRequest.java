package com.FlorDaCidade.controller;

public class AuthRequest {
  private String email; // Use 'email' em vez de 'username'
  private String password;

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
}