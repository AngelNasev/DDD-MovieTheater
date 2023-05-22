package emt.ticketreservation.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.ticketreservation.domain.valueobjects.TicketValueObjectId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Table(name = "reservations")
public class Reservations extends AbstractEntity<ReservationId> {
    @ManyToOne
    private Clients clients;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "reservation_tickets", joinColumns = @JoinColumn(name = "reservation_id"))
    @AttributeOverride(name = "id", column = @Column(name = "ticket_id", nullable = false))
    private List<TicketValueObjectId> ticketIdList = new ArrayList<>();
    private LocalDateTime timeOfReservation;

    public Reservations(Clients clients) {
        super(ReservationId.randomId(ReservationId.class));
        this.clients = clients;
        this.timeOfReservation = LocalDateTime.now();
    }
    public Reservations() {
        super(ReservationId.randomId(ReservationId.class));
    }
    public List<TicketValueObjectId> getTicketIdList() {
        if (ticketIdList == null) {
            ticketIdList = new ArrayList<>();
        }
        return ticketIdList;
    }
    public void addTicket(@NonNull TicketValueObjectId ticketValueObjectId){
        Objects.requireNonNull(ticketValueObjectId,"ticket must not be null");
        ticketIdList.add(ticketValueObjectId);
    }
    public void removeTicket(@NonNull TicketValueObjectId ticketValueObjectId){
        Objects.requireNonNull(ticketValueObjectId,"ticket must not be null");
        ticketIdList.remove(ticketValueObjectId);
    }
}
