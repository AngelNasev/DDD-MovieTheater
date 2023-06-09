package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class TicketId extends DomainObjectId {
    private TicketId() {
        super(TicketId.randomId(TicketId.class).getId());
    }

    public TicketId(@NonNull String uuid) {
        super(uuid);
    }

    public static TicketId of(String uuid) {
        TicketId p = new TicketId(uuid);
        return p;
    }
}
