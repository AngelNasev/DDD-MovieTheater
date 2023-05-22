package emt.ticketreservation.services;

import emt.ticketreservation.domain.models.ClientId;
import emt.ticketreservation.domain.models.Clients;
import emt.ticketreservation.domain.service.forms.ClientForm;

import java.util.List;

public interface ClientService {
    Clients findById(ClientId id);
    Clients createClient(ClientForm form);
    List<Clients> getAll();
}
