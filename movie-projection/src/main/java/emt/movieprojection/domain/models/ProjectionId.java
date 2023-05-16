package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ProjectionId extends DomainObjectId {
    private ProjectionId() {
        super(ProjectionId.randomId(ProjectionId.class).getId());
    }

    protected ProjectionId(@NonNull String uuid) {
        super(uuid);
    }
}
