package com.example.democinema.repository;

import com.example.democinema.model.Reservation;
import com.example.democinema.model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
