package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.financial.Money;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Table(name = "projections")
public class Projections extends AbstractEntity<ProjectionId> {

    @Column(name = "movie_theater_id")
    private MovieTheaterId movieTheaterId;
    @Column(name = "movie_id")
    private MovieId movieId;

    private Money ticketPrice;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();
    private LocalDateTime dateTimeOfProjection;

    public Projections(@NonNull MovieTheaterId movieTheaterId,
                       @NonNull Money ticketPrice,
                       @NonNull MovieId movieId,
                       @NonNull LocalDateTime dateTimeOfProjection) {
        super(ProjectionId.randomId(ProjectionId.class));
        this.movieTheaterId = movieTheaterId;
        this.ticketPrice = ticketPrice;
        this.movieId = movieId;
        this.dateTimeOfProjection = dateTimeOfProjection;
    }

    public Projections() {
        super(ProjectionId.randomId(ProjectionId.class));
    }

    public boolean isTicketAlreadyReserved(Ticket ticket) {
        return tickets.stream()
                .anyMatch(t -> t == ticket && t.isReserved());
    }

    public void addTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void reserveTicket(@NonNull Ticket ticket) {
        Objects.requireNonNull(ticket, "Ticket must not be null");
        tickets.stream().filter(t -> t == ticket).findFirst().ifPresent(Ticket::bookTicket);
    }

    public void cancelTicket(@NonNull Ticket ticket) {
        Objects.requireNonNull(ticket, "Ticket must not be null");
        tickets.stream().filter(t -> t == ticket).findFirst().ifPresent(Ticket::cancelTicket);
    }
}