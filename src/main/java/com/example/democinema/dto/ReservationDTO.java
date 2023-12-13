package com.example.democinema.dto;

import com.example.democinema.model.ReservationId;
import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.model.User;

import java.time.LocalDateTime;

public class ReservationDTO {

    private final LocalDateTime registeredAt;
    private final ScreeningDTO screening;
    private final UserDTO user;

    public ReservationDTO(LocalDateTime registeredAt, ScreeningDTO screening, UserDTO user) {
        this.registeredAt = registeredAt;
        this.screening = screening;
        this.user = user;
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
