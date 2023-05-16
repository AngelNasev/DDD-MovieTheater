package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.financial.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tickets")
public class Tickets extends AbstractEntity<TicketId> {
    private int seatNumber;
    private Money price;
    private MovieTheaterId movieTheaterId; //TODO: mapping instead of ID

}
