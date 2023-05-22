package emt.movieprojection.services;

import emt.movieprojection.domain.models.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();
}
