package emt.shared_kernel.infra;

import emt.shared_kernel.domain.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

