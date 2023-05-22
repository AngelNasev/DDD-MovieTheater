package emt.ticketreservation.domain.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import emt.shared_kernel.domain.base.ValueObject;
import emt.shared_kernel.domain.financial.Currency;
import emt.shared_kernel.domain.financial.Money;
import lombok.Getter;

@Getter
public class TicketValueObject implements ValueObject {
    private final TicketValueObjectId ticketValueObjectId;
    private final int seatNumber;
    private final Money price;

    private final boolean isReserved;

    private TicketValueObject() {
        ticketValueObjectId = TicketValueObjectId.randomId(TicketValueObjectId.class);
        seatNumber = 0;
        price = Money.valueOf(Currency.MKD, 0);
        isReserved = false;
    }

    @JsonCreator
    public TicketValueObject(@JsonProperty("id") TicketValueObjectId ticketValueObjectId,
                             @JsonProperty("seatNumber") int seatNumber,
                             @JsonProperty("price") Money price,
                             @JsonProperty("reserved") boolean isReserved) {
        this.ticketValueObjectId = ticketValueObjectId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isReserved = isReserved;
    }


}
