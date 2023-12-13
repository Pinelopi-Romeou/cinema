package com.example.democinema.dto;

import com.example.democinema.model.ReservationId;
import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.model.User;

import java.time.LocalDateTime;

public class ReservationDTO {

    private ReservationId id;
    private LocalDateTime registeredAt;
    private ScreeningDTO screening;
    private UserDTO user;

    public ReservationDTO(ReservationId id, LocalDateTime registeredAt, ScreeningDTO screening, UserDTO user) {
        this.id = id;
        this.registeredAt = registeredAt;
        this.screening = screening;
        this.user = user;
    }

    public ReservationDTO(LocalDateTime registeredAt, ScreeningDTO screening) {
        this.registeredAt = registeredAt;
        this.screening = screening;
    }

    public ReservationId getId() {
        return id;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public ScreeningDTO getScreening() {
        return screening;
    }

    public UserDTO getUser() {
        return user;
    }
}
