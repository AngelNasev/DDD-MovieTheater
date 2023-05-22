package emt.ticketreservation.services;


import emt.ticketreservation.domain.models.ReservationId;
import emt.ticketreservation.domain.models.Reservations;
import emt.ticketreservation.domain.service.forms.ReservationForm;
import emt.ticketreservation.domain.valueobjects.ProjectionValueObjectId;
import emt.ticketreservation.domain.valueobjects.TicketValueObject;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    ReservationId makeReservation(ReservationForm reservationForm);
    List<Reservations> getAll();
    Optional<Reservations> findById(ReservationId reservationId);
    void addTicket(ProjectionValueObjectId projectionValueObjectId, ReservationId reservationId, TicketValueObject ticketValueObject);
    void removeTicket(ProjectionValueObjectId projectionValueObjectId, ReservationId reservationId, TicketValueObject ticketValueObject);
}
