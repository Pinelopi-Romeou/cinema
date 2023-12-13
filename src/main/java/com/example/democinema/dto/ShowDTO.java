package com.example.democinema.dto;

import java.util.ArrayList;
import java.util.List;

public class ShowDTO extends BaseDTO {

    private String title;
    private String description;
    private String duration;
    private String director;
    private String genre;
    private String language;
    private String imageName;
    private List<ScreeningDTO> screenings = new ArrayList<>();
    private List<UserDTO> likes = new ArrayList<>();

    public ShowDTO(Long id, String title, String description, String duration, String director, String genre, String language, String imageName) {
        super(id);
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.language = language;
        this.imageName = imageName;
    }

    public ShowDTO(Long id, String title) {
        super(id);
        this.title = title;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<ScreeningDTO> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningDTO> screenings) {
        this.screenings = screenings;
    }

    public List<UserDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<UserDTO> likes) {
        this.likes = likes;
    }
}
