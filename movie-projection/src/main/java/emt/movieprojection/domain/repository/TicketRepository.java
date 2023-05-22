package emt.movieprojection.domain.repository;

import emt.movieprojection.domain.models.Ticket;
import emt.movieprojection.domain.models.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
}
