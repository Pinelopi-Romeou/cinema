package com.example.democinema.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SCREENINGS")
public class Screening {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATETIME")
    private Date dateTime;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOW_ID", nullable = false)
    private Show show;

    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservations = new ArrayList<>();

    public Screening() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}