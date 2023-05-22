package emt.ticketreservation.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.base.DomainObjectId;
import emt.shared_kernel.domain.personal.PersonName;
import emt.ticketreservation.domain.valueobjects.TicketValueObjectId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "clients")
public class Clients extends AbstractEntity<ClientId> {
    private PersonName clientName;
    private String email;
    private String clientUsername;
    private String clientPassword;

    public Clients() {
        super(ClientId.randomId(ClientId.class));
    }

    public static Clients build(@NonNull PersonName clientName,
                   @NonNull String clientUsername,
                   @NonNull String clientPassword) {
        Clients client = new Clients();
        client.clientName = clientName;
        client.clientUsername = clientUsername;
        client.clientPassword = clientPassword;
        return client;
    }
}
