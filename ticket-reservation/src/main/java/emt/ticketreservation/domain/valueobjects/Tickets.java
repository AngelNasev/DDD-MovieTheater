package emt.ticketreservation.domain.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import emt.shared_kernel.domain.base.ValueObject;
import emt.shared_kernel.domain.financial.Currency;
import emt.shared_kernel.domain.financial.Money;
import lombok.Getter;

@Getter
public class Tickets implements ValueObject {
    private final TicketId ticketId;
    private final int seatNumber;
    private final Money price;

    private Tickets() {
        ticketId=TicketId.randomId(TicketId.class);
        seatNumber=0;
        price= Money.valueOf(Currency.MKD,0);
    }

    @JsonCreator
    public Tickets(@JsonProperty() TicketId ticketId,
                   @JsonProperty() int seatNumber,
                   @JsonProperty() Money price) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.price = price;
    }


}
