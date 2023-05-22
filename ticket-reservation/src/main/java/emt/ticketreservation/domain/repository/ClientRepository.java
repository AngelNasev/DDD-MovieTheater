package emt.ticketreservation.domain.repository;

import emt.ticketreservation.domain.models.ClientId;
import emt.ticketreservation.domain.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, ClientId> {
}
