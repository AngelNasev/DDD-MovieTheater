package emt.ticketreservation.domain.valueobjects;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class TicketId extends DomainObjectId {
    private TicketId() {
        super(TicketId.randomId(TicketId.class).getId());
    }

    public TicketId(@NonNull String uuid) {
        super(uuid);
    }

}
