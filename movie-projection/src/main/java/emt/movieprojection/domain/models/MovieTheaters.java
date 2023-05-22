package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Entity
@Getter
@Table(name = "movie_theaters")
public class MovieTheaters extends AbstractEntity<MovieTheaterId> {
    private String movieTheaterName;
    @Positive(message = "Capacity must be a greater that 0")
    private int capacity;

    public MovieTheaters() {
        super(MovieTheaterId.randomId(MovieTheaterId.class));
    }

    public static MovieTheaters build(String movieTheaterName, int capacity) {
        MovieTheaters m = new MovieTheaters();
        m.movieTheaterName = movieTheaterName;
        m.capacity = capacity;
        return m;
    }

}
