package emt.ticketreservation.domain.valueobjects;

import emt.shared_kernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class TicketValueObjectId extends DomainObjectId {
    private TicketValueObjectId() {
        super(TicketValueObjectId.randomId(TicketValueObjectId.class).getId());
    }

    public TicketValueObjectId(@NonNull String uuid) {
        super(uuid);
    }
}
