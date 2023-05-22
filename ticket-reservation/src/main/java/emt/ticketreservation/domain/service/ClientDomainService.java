package emt.ticketreservation.domain.service;

import emt.ticketreservation.domain.models.Clients;
import emt.ticketreservation.domain.service.forms.ClientForm;
import org.springframework.stereotype.Service;

@Service
public class ClientDomainService {
    public Clients toDomainObject(ClientForm clientForm) {
        return Clients.build(clientForm.getClientName(), clientForm.getClientUsername(), clientForm.getClientPassword());
    }
}
