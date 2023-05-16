package emt.ticketreservation.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.personal.PersonName;
import emt.ticketreservation.domain.valueobjects.TicketId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients extends AbstractEntity<ClientId> {
    private PersonName clientName;
    private String email;
    private String clientUsername;
    private String clientPassword;

    @AttributeOverride(name = "id", column = @Column(name = "ticket_id", nullable = false))
    private TicketId ticketId;

}
