package com.example.democinema.dto;

import com.example.democinema.model.Reservation;
import com.example.democinema.model.Show;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class UserInsertDTO {

    @NotBlank(message = "Firstname cannot be empty")
    private String firstname;
    @NotBlank(message = "Lastname cannot be empty")
    private String lastname;
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @Email
    @NotBlank(message = "E-mail cannot be empty")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$", message = "Invalid password format")
    private String password;

    public UserInsertDTO() {}

    public UserInsertDTO(String firstname, String lastname, String username, String email, String password, List<Show> likedShows, List<Reservation> reservations) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
