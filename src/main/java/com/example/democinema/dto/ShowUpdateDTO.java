package com.example.democinema.dto;

import com.example.democinema.model.Screening;
import com.example.democinema.model.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ShowUpdateDTO extends BaseDTO {

    @NotBlank(message = "Titlez cannot be empty")
    private String title;
    private String description;
    private String duration;
    private String director;
    private String genre;
    private String language;

    public ShowUpdateDTO(Long id, String title, String description, String duration, String director, String genre, String language) {
        super(id);
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }


}
