package com.example.democinema.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UpdatePasswordDTO {

    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$", message = "Invalid password format")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
