package com.example.democinema.dto;

import javax.validation.constraints.NotBlank;

public class UpdatePasswordDTO {

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
