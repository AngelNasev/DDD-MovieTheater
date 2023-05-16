package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class MovieId extends DomainObjectId {
    private MovieId() {
        super(MovieId.randomId(MovieId.class).getId());
    }

    protected MovieId(@NonNull String uuid) {
        super(uuid);
    }
}
