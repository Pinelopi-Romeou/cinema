package com.example.democinema.dto;

import com.example.democinema.model.Screening;
import com.example.democinema.model.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationUpdateDTO extends BaseDTO {
    
    private LocalDateTime registeredAt;
    @NotNull
    private Screening screening;
    @NotNull
    private User user;

    public ReservationUpdateDTO(Long id, LocalDateTime registeredAt, Screening screening, User user) {
        super(id);
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

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
