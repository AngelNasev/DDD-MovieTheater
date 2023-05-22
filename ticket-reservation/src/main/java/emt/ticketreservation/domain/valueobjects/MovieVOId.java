package emt.ticketreservation.domain.valueobjects;

import emt.shared_kernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class MovieVOId extends DomainObjectId {
    private MovieVOId() {
        super(MovieVOId.randomId(MovieVOId.class).getId());
    }
    public MovieVOId(@NonNull String uuid) {
        super(uuid);
    }
}
