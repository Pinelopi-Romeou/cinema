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

@Component
public class CinemaInitializer {

    private final ShowRepository showRepository;

    @Autowired
    public CinemaInitializer(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    //    @PostConstruct
    public void init() {
        showRepository.save(new Show("Treasure Planet", "Jim Hawkins is a teenager who finds the map of a great treasure hidden by a space pirate. Together with some friends, he sets off in a large spaceship, shaped like a caravel, on his quest.",
                "95", "Ron Clements, John Musker", "animation", "english", "animation"));
        showRepository.save(new Show("Mystery of the Northern Lights", "The aurora borealis is one of Earth's most incredible sights, and new discoveries finally explain why these mysterious lights appear and what they reveal about the Sun's sinister and deadly powers.",
                "51", "Tom Ranson", "documentary", "english", "selas"));
        showRepository.save(new Show("Journey to the Edge of the Universe", "A journey through space and time.",
                "91", "Yavar Abbas", "documentary", "english", "journey"));
    }
}
