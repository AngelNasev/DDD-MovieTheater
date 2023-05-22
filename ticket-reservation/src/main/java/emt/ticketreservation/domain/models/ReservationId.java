package emt.ticketreservation.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ReservationId extends DomainObjectId {
    private ReservationId() {
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public ReservationId(@NonNull String uuid) {
        super(uuid);
    }
}
