package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.personal.PersonName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "movies")
public class Movies extends AbstractEntity<MovieId> {
    private String movieName;
    @Enumerated(value = EnumType.STRING)
    private Genre movieGenre;
    private PersonName director;
    private int duration;

}
