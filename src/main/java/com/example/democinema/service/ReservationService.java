package com.example.democinema.service;

import com.example.democinema.dto.ReservationDTO;
import com.example.democinema.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface ReservationService {

    void createReservation(String username, Long screeningId) throws EntityNotFoundException;

    List<ReservationDTO> getAllReservations();
}
