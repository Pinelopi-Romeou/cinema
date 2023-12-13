package com.example.democinema.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOWS")
public class Show {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE", length = 50, nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", length = 512)
    private String description;

    @Column(name = "DURATION")
    private String duration;

    @Column(name = "DIRECTOR", length = 50)
    private String director;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "IMG_NAME")
    private String imageName;

    @ManyToMany(mappedBy = "likedShows")
    List<User> likes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "show")
    private List<Screening> screenings = new ArrayList<>();

    public Show() {}

    public Show(String title, String description, String duration, String director, String genre, String language, String imageName) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.language = language;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public List<Screening> getScreenings() {
        return screenings;
    }
    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }
    public List<User> getLikes() {
        return likes;
    }
    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
}
