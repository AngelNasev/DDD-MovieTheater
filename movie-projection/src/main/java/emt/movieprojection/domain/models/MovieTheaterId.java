package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class MovieTheaterId extends DomainObjectId {
    private MovieTheaterId() {
        super(MovieTheaterId.randomId(MovieTheaterId.class).getId());
    }

    public MovieTheaterId(@NonNull String uuid) {
        super(uuid);
    }
}
