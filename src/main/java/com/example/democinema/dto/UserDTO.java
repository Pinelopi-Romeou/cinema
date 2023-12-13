package com.example.democinema.dto;

import com.example.democinema.model.Reservation;
import com.example.democinema.model.Show;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends BaseDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private List<ShowDTO> likedShows = new ArrayList<>();
    private List<ScreeningDTO> reservations = new ArrayList<>();

    public UserDTO(Long id, String firstname, String lastname, String username, String email) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public UserDTO(Long id) {
        super(id);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<ShowDTO> getLikedShows() {
        return likedShows;
    }

    public void setLikedShows(List<ShowDTO> likedShows) {
        this.likedShows = likedShows;
    }

    public List<ScreeningDTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<ScreeningDTO> reservations) {
        this.reservations = reservations;
    }
}
