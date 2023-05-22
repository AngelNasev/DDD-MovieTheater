package emt.movieprojection.services.impl;

import emt.movieprojection.domain.models.Ticket;
import emt.movieprojection.domain.repository.TicketRepository;
import emt.movieprojection.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}
