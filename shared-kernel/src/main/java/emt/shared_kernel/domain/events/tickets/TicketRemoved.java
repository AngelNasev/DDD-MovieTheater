package emt.shared_kernel.domain.events.tickets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import emt.shared_kernel.domain.config.TopicHolder;
import emt.shared_kernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class TicketRemoved extends DomainEvent {
    private String projectionId;
    private String ticketId;

    public TicketRemoved(String topic) {
        super(TopicHolder.TOPIC_TICKET_REMOVED);
    }


    @JsonCreator
    public TicketRemoved(@JsonProperty("projectionId") String projectionId, @JsonProperty("ticketId") String ticketId) {
        super(TopicHolder.TOPIC_TICKET_REMOVED);
        this.projectionId = projectionId;
        this.ticketId = ticketId;
    }
}
