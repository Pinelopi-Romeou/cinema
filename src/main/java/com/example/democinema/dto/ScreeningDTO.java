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

    public ShowDTO getShow() {
        return show;
    }

    public void setShow(ShowDTO show) {
        this.show = show;
    }
}
