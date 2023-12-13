package com.example.democinema.service;

import com.example.democinema.dto.*;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface ShowService {

    ShowDTO insertShow(ShowInsertDTO dto) throws EntityAlreadyExistsException;
    ShowDTO updateShow(Long id, ShowUpdateDTO dto) throws EntityNotFoundException, EntityAlreadyExistsException;
    void deleteShow(Long id) throws EntityNotFoundException;
    ShowDTO getShowById(Long id) throws EntityNotFoundException;
    List<ShowDTO> getAllShows();
}
