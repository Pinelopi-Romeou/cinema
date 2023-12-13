package com.example.democinema.service;

import com.example.democinema.dto.*;
import com.example.democinema.service.exceptions.EntityAlreadyExistsException;
import com.example.democinema.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface ShowService {

    ShowDTO getShowById(Long id) throws EntityNotFoundException;

    List<ShowDTO> getAllShows();
}
