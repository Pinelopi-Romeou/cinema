package com.example.democinema;

import com.example.democinema.model.Reservation;
import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.repository.ReservationRepository;
import com.example.democinema.repository.ScreeningRepository;
import com.example.democinema.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Date;

@Component
public class CinemaInitializer {

    private final ShowRepository showRepository;

    private final ScreeningRepository screeningRepository;

    @Autowired
    public CinemaInitializer(ShowRepository showRepository, ScreeningRepository screeningRepository) {
        this.showRepository = showRepository;
        this.screeningRepository = screeningRepository;
    }

    @PostConstruct
    public void init() {
        Show s1 = new Show("Treasure Planet", "Jim Hawkins is a teenager who finds the map of a great treasure hidden by a space pirate. Together with some friends, he sets off in a large spaceship, shaped like a caravel, on his quest.",
                "95", "Ron Clements, John Musker", "animation", "english", "animation");
        Show s2 = new Show("Mystery of the Northern Lights", "The aurora borealis is one of Earth's most incredible sights, and new discoveries finally explain why these mysterious lights appear and what they reveal about the Sun's sinister and deadly powers.",
                "51", "Tom Ranson", "documentary", "english", "selas");
        Show s3 = new Show("Journey to the Edge of the Universe", "A journey through space and time.",
                "91", "Yavar Abbas", "documentary", "english", "journey");
        showRepository.save(s1);
        showRepository.save(s2);
        showRepository.save(s3);

        Screening scr1 = new Screening(Date.from(Instant.parse("2023-10-10T11:10:00Z")), 15.0, s1);
        Screening scr2 = new Screening(Date.from(Instant.parse("2023-11-10T11:10:00Z")), 12.0, s1);
        Screening scr3 = new Screening(Date.from(Instant.parse("2023-10-10T11:10:00Z")), 17.0, s2);
        Screening scr4 = new Screening(Date.from(Instant.parse("2023-10-10T11:10:00Z")), 11.0, s2);
        Screening scr5 = new Screening(Date.from(Instant.parse("2023-09-10T11:10:00Z")), 19.0, s3);
        Screening scr6 = new Screening(Date.from(Instant.parse("2023-07-10T11:10:00Z")), 15.0, s3);

        screeningRepository.save(scr1);
        screeningRepository.save(scr2);
        screeningRepository.save(scr3);
        screeningRepository.save(scr4);
        screeningRepository.save(scr5);
        screeningRepository.save(scr6);
    }
}
