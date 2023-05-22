package emt.ticketreservation.services.impl;

import emt.ticketreservation.domain.exceptions.ClientNotFoundException;
import emt.ticketreservation.domain.models.ClientId;
import emt.ticketreservation.domain.models.Clients;
import emt.ticketreservation.domain.repository.ClientRepository;
import emt.ticketreservation.domain.service.ClientDomainService;
import emt.ticketreservation.domain.service.forms.ClientForm;
import emt.ticketreservation.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientDomainService clientDomainService;

    public ClientServiceImpl(ClientRepository clientRepository, ClientDomainService clientDomainService) {
        this.clientRepository = clientRepository;
        this.clientDomainService = clientDomainService;
    }

    @Override
    public Clients findById(ClientId id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Clients createClient(ClientForm form) {
        Objects.requireNonNull(form, "Client form must not be null!");
        return clientRepository.saveAndFlush(clientDomainService.toDomainObject(form));
    }

    @Override
    public List<Clients> getAll() {
        return clientRepository.findAll();
    }
}
