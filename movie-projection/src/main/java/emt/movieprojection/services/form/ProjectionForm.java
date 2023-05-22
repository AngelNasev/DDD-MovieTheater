package emt.movieprojection.services.form;

import emt.movieprojection.domain.models.MovieId;
import emt.movieprojection.domain.models.MovieTheaterId;
import emt.shared_kernel.domain.financial.Money;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectionForm {
    private MovieTheaterId movieTheaterId;
    private Money ticketPrice;
    private MovieId movieId;
    private LocalDateTime dateTimeOfProjection;
}
