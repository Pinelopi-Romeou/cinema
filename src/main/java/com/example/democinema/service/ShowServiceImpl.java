package com.example.democinema.service;

import com.example.democinema.dto.*;
import com.example.democinema.model.Screening;
import com.example.democinema.model.Show;
import com.example.democinema.model.User;
import com.example.democinema.repository.ShowRepository;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public ShowDTO insertShow(ShowInsertDTO dto) throws EntityAlreadyExistsException {
            Show show = map(dto);
            if (showRepository.existsById(show.getId())) {
                showRepository.save(show);

                return map(show);
            } else {
                throw new EntityAlreadyExistsException(Show.class, 0L);
            }
    }

    @Transactional
    @Override
    public ShowDTO updateShow(Long id, ShowUpdateDTO dto) throws EntityNotFoundException {
        Optional<Show> show = showRepository.findById(id);

            if (show.isPresent()) {
                merge(show.get(), dto);
                showRepository.save(show.get());

                return map(show.get());
            } else {
                throw new EntityNotFoundException(Show.class, 0L);
            }
    }

    @Override
    public void deleteShow(Long id) throws EntityNotFoundException {
        Optional<Show> show = showRepository.findById(id);
        if (show.isPresent()) {
            showRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(User.class, 0L);
        }
    }

    @Override
    public ShowDTO getShowById(Long id) throws EntityNotFoundException {
            Optional<Show> show = showRepository.findById(id);
            if (show.isPresent()) {
                Show s = show.get();
                return map(s);
            } else {
                throw new EntityNotFoundException(Show.class, 0L);
            }
    }

//    @Override
//    public List<ShowDTO> getShowsByTitle(String title) {
//        List<Show> shows = showRepository.getByTitle(title);
//        List<ShowDTO> showDTOS = new ArrayList<>();
//
//        for (Show s : shows) {
//            showDTOS.add(map(s));
//        }
//        return showDTOS;
//    }

    @Transactional
    @Override
    public List<ShowDTO> getAllShows() {
        List<ShowDTO> showDTOS = new ArrayList<>();
        List<Show> shows = showRepository.findAll();

        for (Show s : shows) {
            showDTOS.add(map(s));
        }
        return showDTOS;
    }


    private Show map(ShowInsertDTO dto) {
        return new Show(dto.getTitle(), dto.getDescription(), dto.getDuration(), dto.getDirector(), dto.getGenre(), dto.getLanguage(), dto.getImageName());
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

    private void merge(Show show, ShowUpdateDTO dto) {
        if (dto.getTitle() != null) {
            show.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            show.setDescription(dto.getDescription());
        }
        if (dto.getDuration() != null) {
            show.setDuration(dto.getDuration());
        }
        if (dto.getDirector() != null) {
            show.setDirector(dto.getDirector());
        }
        if (dto.getGenre() != null) {
            show.setGenre(dto.getGenre());
        }
        if (dto.getLanguage() != null) {
            show.setLanguage(dto.getLanguage());
        }
    }
}
