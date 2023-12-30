package com.example.democinema.service;

import com.example.democinema.dto.ReservationDTO;
import com.example.democinema.dto.ScreeningDTO;
import com.example.democinema.dto.ShowDTO;
import com.example.democinema.dto.UserDTO;
import com.example.democinema.model.*;
import com.example.democinema.repository.ReservationRepository;
import com.example.democinema.repository.ScreeningRepository;
import com.example.democinema.repository.UserRepository;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final ScreeningRepository screeningRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, ScreeningRepository screeningRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.screeningRepository = screeningRepository;
    }

    /**
     * Finds and returns all reservations
     * @return a list of reservations
     */
    @Override
    public List<ReservationDTO> getAllReservations() {
        List<ReservationDTO> resDTO = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findAll();

        for (Reservation r : reservations) {
            resDTO.add(map(r));
        }
        return resDTO;
    }

    /**
     * Creates a new reservation
     * @param username the username of the user that makes the reservation
     * @param screeningId the id of the screening that is being reserved
     * @throws EntityNotFoundException if the user or the screening is not found
     */
    @Transactional
    @Override
    public void createReservation(String username, Long screeningId) throws EntityNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, username);
        }
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        if (screening.isEmpty()) {
            throw new EntityNotFoundException(Screening.class, screeningId);
        }

        ReservationId reservationId = new ReservationId(user.getId(), screening.get().getId());

        Reservation reservation = new Reservation(reservationId);

        reservation.setScreening(screening.get());
        reservation.setUser(user);
        reservationRepository.save(reservation);
    }

    private ScreeningDTO map(Screening screening) {
        return new ScreeningDTO(screening.getId(), screening.getDateTime(), screening.getPrice(), map(screening.getShow()));
    }

    private ReservationDTO map(Reservation reservation) {
        return new ReservationDTO(reservation.getRegisteredAt(), map(reservation.getScreening()), map(reservation.getUser()));
    }

    private UserDTO map(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }

    private ShowDTO map(Show show) {
        return new ShowDTO(show.getId(), show.getTitle());
    }
}
