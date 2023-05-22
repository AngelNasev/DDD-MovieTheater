package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.personal.PersonName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Entity
@Getter
@Table(name = "movies")
public class Movies extends AbstractEntity<MovieId> {
    private String movieName;
    @Enumerated(value = EnumType.STRING)
    private Genre movieGenre;
    @NotNull
    private PersonName director;
    @NotNull
    @Positive(message = "Duration must be a greater that 0")
    private int duration;

    public Movies() {
        super(MovieId.randomId(MovieId.class));
    }

    public static Movies build(String movieName, Genre movieGenre, PersonName director, int duration) {
        Movies m = new Movies();
        m.movieName = movieName;
        m.movieGenre = movieGenre;
        m.director = director;
        m.duration = duration;
        return m;
    }

}
