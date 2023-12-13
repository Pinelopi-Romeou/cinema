package com.example.democinema.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private LocalDateTime registeredAt;
    private ScreeningDTO screening;
    private UserDTO user;

    public ReservationDTO(LocalDateTime registeredAt, ScreeningDTO screening, UserDTO user) {
        this.registeredAt = registeredAt;
        this.screening = screening;
        this.user = user;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public ScreeningDTO getScreening() {
        return screening;
    }

    public void setScreening(ScreeningDTO screening) {
        this.screening = screening;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
