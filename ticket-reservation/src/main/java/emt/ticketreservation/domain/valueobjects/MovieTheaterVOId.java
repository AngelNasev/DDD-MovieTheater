package emt.ticketreservation.domain.valueobjects;

import emt.shared_kernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class MovieTheaterVOId extends DomainObjectId {
    private MovieTheaterVOId() {
        super(MovieTheaterVOId.randomId(MovieTheaterVOId.class).getId());
    }
    public MovieTheaterVOId(@NonNull String uuid) {
        super(uuid);
    }
}
