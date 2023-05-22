package emt.ticketreservation.domain.repository;

import emt.ticketreservation.domain.models.ReservationId;
import emt.ticketreservation.domain.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservations, ReservationId> {
}
