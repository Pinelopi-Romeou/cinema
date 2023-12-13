package com.example.democinema.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends BaseDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private List<ShowDTO> likedShows = new ArrayList<>();
    private List<ScreeningDTO> reservations = new ArrayList<>();

    public UserDTO(Long id, String firstname, String lastname, String username, String email) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public UserDTO(Long id, String username, String email) {
        super(id);
        this.username = username;
        this.email = email;
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
