package com.grp.graphle.user.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    @NotBlank(message = "Username tidak boleh kosong")
    private String username;
    @Email(message = "Format email tidak valid")
    @NotBlank
    private String email;
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}