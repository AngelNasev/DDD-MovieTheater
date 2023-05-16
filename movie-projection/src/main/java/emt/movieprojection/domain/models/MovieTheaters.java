package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "movie_theaters")
public class MovieTheaters extends AbstractEntity<MovieTheaterId> {
    private String movieTheaterName;
    private int capacity;

}
