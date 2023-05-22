package emt.ticketreservation.services.impl;

import emt.shared_kernel.domain.events.tickets.TicketRemoved;
import emt.shared_kernel.domain.events.tickets.TicketReserved;
import emt.shared_kernel.infra.DomainEventPublisher;
import emt.ticketreservation.domain.exceptions.ReservationNotFoundException;
import emt.ticketreservation.domain.models.ReservationId;
import emt.ticketreservation.domain.models.Reservations;
import emt.ticketreservation.domain.repository.ReservationRepository;
import emt.ticketreservation.domain.service.forms.ReservationForm;
import emt.ticketreservation.domain.valueobjects.ProjectionValueObjectId;
import emt.ticketreservation.domain.valueobjects.TicketValueObject;
import emt.ticketreservation.services.ReservationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final DomainEventPublisher domainEventPublisher;


    @Override
    public ReservationId makeReservation(ReservationForm reservationForm) {
        Objects.requireNonNull(reservationForm.getClient(), "clientId must not be null");

        Reservations reservation = new Reservations(reservationForm.getClient());
        var newReservation = reservationRepository.saveAndFlush(reservation);
        return newReservation.getId();
    }

    @Override
    public List<Reservations> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservations> findById(ReservationId reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void addTicket(ProjectionValueObjectId projectionValueObjectId, ReservationId reservationId, TicketValueObject ticketValueObject){
        var reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationNotFoundException::new);
        reservation.addTicket(ticketValueObject.getTicketValueObjectId());
        reservationRepository.saveAndFlush(reservation);
        domainEventPublisher.publish(new TicketReserved(projectionValueObjectId.getId(),ticketValueObject.getTicketValueObjectId().getId()));
    }

    @Override
    public void removeTicket(ProjectionValueObjectId projectionValueObjectId, ReservationId reservationId, TicketValueObject ticketValueObject) {
        var reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationNotFoundException::new);
        reservation.removeTicket(ticketValueObject.getTicketValueObjectId());
        reservationRepository.saveAndFlush(reservation);
        domainEventPublisher.publish(new TicketRemoved(projectionValueObjectId.getId(),ticketValueObject.getTicketValueObjectId().getId()));
    }
}
