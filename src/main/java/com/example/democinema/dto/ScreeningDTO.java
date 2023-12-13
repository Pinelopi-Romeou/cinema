package com.example.democinema.dto;

import java.util.Date;

public class ScreeningDTO extends BaseDTO {

    private Date dateTime;
    private double price;
    private ShowDTO show;

    public ScreeningDTO(Long id, Date dateTime, double price, ShowDTO show) {
        super(id);
        this.dateTime = dateTime;
        this.price = price;
        this.show = show;
    }

    public ScreeningDTO(Long id, Date dateTime, double price) {
        super(id);
        this.dateTime = dateTime;
        this.price = price;
    }

    public ScreeningDTO(Long id) {
        super(id);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public double getPrice() {
        return price;
    }

    public ShowDTO getShow() {
        return show;
    }
}
