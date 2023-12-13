package com.example.democinema.dto;

import com.example.democinema.model.Reservation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ScreeningUpdateDTO extends BaseDTO {

    private Date dateTime;
    @NotBlank(message = "Price cannot be empty")
    private double price;
    @NotNull
    private Long showId;

    public ScreeningUpdateDTO(Long id, Date dateTime, double price, Long showId) {
        super(id);
        this.dateTime = dateTime;
        this.price = price;
        this.showId = showId;
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

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
