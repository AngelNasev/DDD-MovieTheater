package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ProjectionId extends DomainObjectId {
    private ProjectionId() {
        super(ProjectionId.randomId(ProjectionId.class).getId());
    }

    public ProjectionId(@NonNull String uuid) {
        super(uuid);
    }

    public static ProjectionId of(String uuid) {
        ProjectionId p = new ProjectionId(uuid);
        return p;
    }

}
