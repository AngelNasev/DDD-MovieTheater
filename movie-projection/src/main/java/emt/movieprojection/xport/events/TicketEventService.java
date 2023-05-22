package emt.movieprojection.xport.events;

import emt.movieprojection.domain.models.ProjectionId;
import emt.movieprojection.services.ProjectionService;
import emt.shared_kernel.domain.config.TopicHolder;
import emt.shared_kernel.domain.events.DomainEvent;
import emt.shared_kernel.domain.events.tickets.TicketRemoved;
import emt.shared_kernel.domain.events.tickets.TicketReserved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TicketEventService {
    private final ProjectionService projectionService;

    public TicketEventService(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @KafkaListener(topics = TopicHolder.TOPIC_TICKET_RESERVED, groupId = "ticketReservation")
    public void consumeTicketReservedEvent(@Payload(required = false) String jsonMessage) {
        try {
            TicketReserved event = DomainEvent.fromJson(jsonMessage, TicketReserved.class);
            projectionService.reserveTicket(ProjectionId.of(event.getProjectionId()), event.getTicketId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_TICKET_REMOVED, groupId = "ticketReservation")
    public void consumeOrderItemRemovedEvent(@Payload(required = false) String jsonMessage) {
        try {
            TicketRemoved event = DomainEvent.fromJson(jsonMessage, TicketRemoved.class);
            projectionService.cancelTicket(ProjectionId.of(event.getProjectionId()), event.getTicketId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
