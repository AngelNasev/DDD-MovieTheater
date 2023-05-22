package emt.ticketreservation.xport.rest;


import emt.ticketreservation.domain.models.Clients;
import emt.ticketreservation.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Clients> getAll(){
        return clientService.getAll();
    }
}
