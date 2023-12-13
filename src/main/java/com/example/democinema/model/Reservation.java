package com.example.democinema.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @EmbeddedId
    ReservationId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    User user;

    @ManyToOne
    @MapsId("screeningId")
    @JoinColumn(name = "SCREENING_ID")
    Screening screening;

    private LocalDateTime registeredAt = LocalDateTime.now();

    public Reservation() {}

    public Reservation(ReservationId id) {
        this.id = id;
    }

    public ReservationId getId() {
        return id;
    }
    public void setId(ReservationId id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Screening getScreening() {
        return screening;
    }
    public void setScreening(Screening screening) {
        this.screening = screening;
    }
    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }
    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
