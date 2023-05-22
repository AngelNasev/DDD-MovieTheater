package emt.movieprojection.domain.models;

import emt.shared_kernel.domain.base.AbstractEntity;
import emt.shared_kernel.domain.base.DomainObjectId;
import emt.shared_kernel.domain.financial.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NonNull;

@Entity
@Getter
@Table(name = "ticket")
public class Ticket extends AbstractEntity<TicketId> {
    @Positive(message = "Seat number must be a greater that 0")
    private int seatNumber;
    private Money price;
    private boolean isReserved;

    protected Ticket() {
        super(DomainObjectId.randomId(TicketId.class));
        isReserved=false;
    }

    public Ticket(int seatNumber, @NonNull Money price, boolean isReserved) {
        super(DomainObjectId.randomId(TicketId.class));
        this.seatNumber = seatNumber;
        this.price = price;
        this.isReserved=isReserved;
    }

    public void bookTicket() {
        this.isReserved = true;
    }
    public void cancelTicket() {
        this.isReserved = false;
    }
}
