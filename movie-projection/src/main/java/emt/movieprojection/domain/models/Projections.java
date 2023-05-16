package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "projections")
public class Projections extends AbstractEntity<ProjectionId> {
    private MovieTheaterId movieTheaterId; //TODO: mapping instead of ID
    private MovieId movieId; //TODO: mapping instead of ID
    private LocalDateTime dateTimeOfProjection;

    private int availableTickets;

}
