package com.example.democinema.dto;

import java.util.ArrayList;
import java.util.List;

public class ShowDTO extends BaseDTO {

    private final String title;
    private final String description;
    private final String duration;
    private final String director;
    private final String genre;
    private final String language;
    private final String imageName;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getImageName() {
        return imageName;
    }

    public List<ScreeningDTO> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningDTO> screenings) {
        this.screenings = screenings;
    }

    public void setLikes(List<UserDTO> likes) {
        this.likes = likes;
    }

    public List<UserDTO> getLikes() {
        return likes;
    }
}
