package emt.ticketreservation.domain.valueobjects;

import emt.shared_kernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

@Embeddable
public class ProjectionValueObjectId extends DomainObjectId {
    private ProjectionValueObjectId() {
        super(ProjectionValueObjectId.randomId(ProjectionValueObjectId.class).getId());
    }

    public ProjectionValueObjectId(@NonNull String uuid) {
        super(uuid);
    }
}
