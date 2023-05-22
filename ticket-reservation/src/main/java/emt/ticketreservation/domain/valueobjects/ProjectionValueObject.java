package emt.ticketreservation.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import emt.shared_kernel.domain.base.ValueObject;
import emt.shared_kernel.domain.financial.Currency;
import emt.shared_kernel.domain.financial.Money;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ProjectionValueObject implements ValueObject {
    private final ProjectionValueObjectId projectionValueObjectId;
    private final MovieTheaterVOId movieTheaterId;
    private final MovieVOId movieId;
    private final Money ticketPrice;
    private final List<TicketValueObject> tickets;
    private final LocalDateTime dateTimeOfProjection;

    public ProjectionValueObject() {
        projectionValueObjectId = ProjectionValueObjectId.randomId(ProjectionValueObjectId.class);
        movieTheaterId=MovieTheaterVOId.randomId(MovieTheaterVOId.class);
        movieId=MovieVOId.randomId(MovieVOId.class);
        ticketPrice= Money.valueOf(Currency.MKD,0);
        tickets=new ArrayList<>();
        dateTimeOfProjection=LocalDateTime.now();
    }
    @JsonCreator
    public ProjectionValueObject(@JsonProperty("id") ProjectionValueObjectId projectionValueObjectId,
                                 @JsonProperty("movieTheaterId") MovieTheaterVOId movieTheaterId,
                                 @JsonProperty("movieId") MovieVOId movieId,
                                 @JsonProperty("ticketPrice") Money ticketPrice,
                                 @JsonProperty("tickets") List<TicketValueObject> tickets,
                                 @JsonProperty("dateTimeOfProjection") LocalDateTime dateTimeOfProjection) {
        this.projectionValueObjectId = projectionValueObjectId;
        this.movieTheaterId = movieTheaterId;
        this.movieId = movieId;
        this.ticketPrice = ticketPrice;
        this.tickets = tickets;
        this.dateTimeOfProjection = dateTimeOfProjection;
    }
}
