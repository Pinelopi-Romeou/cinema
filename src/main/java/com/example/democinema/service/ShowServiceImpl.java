package com.example.democinema.service;

import com.example.democinema.dto.*;
import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.repository.ShowRepository;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public ShowDTO getShowById(Long id) throws EntityNotFoundException {
            Optional<Show> show = showRepository.findById(id);
            if (show.isPresent()) {
                Show s = show.get();
                return map(s);
            } else {
                throw new EntityNotFoundException(Show.class, id);
            }
    }

    @Override
    public List<ShowDTO> getAllShows() {
        List<ShowDTO> showDTOS = new ArrayList<>();
        List<Show> shows = showRepository.findAll();

        for (Show s : shows) {
            showDTOS.add(map(s));
        }
        return showDTOS;
    }

    private ShowDTO map(Show dto) {
        ShowDTO show = new ShowDTO(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getDuration(), dto.getDirector(), dto.getGenre(), dto.getLanguage(), dto.getImageName());
        List<ScreeningDTO> screenings = new ArrayList<>();
        for (Screening s : dto.getScreenings()) {
            screenings.add(map(s));
        }
        show.setScreenings(screenings);
        return show;
    }

    private ScreeningDTO map(Screening screening) {
        return new ScreeningDTO(screening.getId(), screening.getDateTime(), screening.getPrice());
    }
}
