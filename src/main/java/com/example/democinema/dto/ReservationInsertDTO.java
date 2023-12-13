package com.example.democinema.dto;

import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationInsertDTO {

    private LocalDateTime registeredAt;
    @NotNull
    private ScreeningDTO screening;
    @NotNull
    private UserDTO user;

    public ReservationInsertDTO(LocalDateTime registeredAt, ScreeningDTO screening, UserDTO user) {
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
