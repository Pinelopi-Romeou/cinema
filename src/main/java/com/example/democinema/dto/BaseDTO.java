package com.example.democinema.dto;

import javax.validation.constraints.NotNull;

public abstract class BaseDTO {

    @NotNull
    private Long id;

    public BaseDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
