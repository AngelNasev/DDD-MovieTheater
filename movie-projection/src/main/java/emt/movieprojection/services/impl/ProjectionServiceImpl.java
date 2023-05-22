package emt.movieprojection.services.impl;

import emt.movieprojection.domain.exceptions.MovieTheaterNotFoundException;
import emt.movieprojection.domain.exceptions.ProjectionNotFoundException;
import emt.movieprojection.domain.exceptions.TicketNotReservedException;
import emt.movieprojection.domain.models.*;
import emt.movieprojection.domain.repository.MovieTheaterRepository;
import emt.movieprojection.domain.repository.ProjectionRepository;
import emt.movieprojection.domain.repository.TicketRepository;
import emt.movieprojection.services.ProjectionService;
import emt.movieprojection.services.form.ProjectionForm;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;
    private final MovieTheaterRepository movieTheaterRepository;
    private final TicketRepository ticketRepository;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieTheaterRepository movieTheaterRepository, TicketRepository ticketRepository) {
        this.projectionRepository = projectionRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public ProjectionId createProjection(ProjectionForm projectionForm) {
        Objects.requireNonNull(projectionForm.getMovieTheaterId(), "movieTheaterId must not be null");
        Objects.requireNonNull(projectionForm.getMovieId(), "movieId must not be null");

        Projections projection = new Projections(projectionForm.getMovieTheaterId(),projectionForm.getTicketPrice(),projectionForm.getMovieId(),projectionForm.getDateTimeOfProjection());

        MovieTheaters movieTheater = movieTheaterRepository.findById(projectionForm.getMovieTheaterId()).orElseThrow(MovieTheaterNotFoundException::new);
        List<Ticket> tickets=new ArrayList<>();
        for (int i=0;i<movieTheater.getCapacity();i++){
            tickets.add(new Ticket(i+1,projection.getTicketPrice(),false));
        }
        projection.addTickets(tickets);

        projection = projectionRepository.saveAndFlush(projection);
        return projection.getId();
    }

    @Override
    public List<Projections> findAll() {
        return projectionRepository.findAll();
    }

    @Override
    public Optional<Projections> findById(ProjectionId projectionId) {
        return projectionRepository.findById(projectionId);
    }

    @Override
    public void reserveTicket(ProjectionId projectionId, String ticketId) {
        Projections projection = findById(projectionId).orElseThrow(ProjectionNotFoundException::new);
        Ticket ticket = ticketRepository.findById(TicketId.of(ticketId)).orElseThrow(TicketNotReservedException::new);
        if (availableTickets(projectionId)>0 && !projection.isTicketAlreadyReserved(ticket)){
            projection.reserveTicket(ticket);
            ticketRepository.saveAndFlush(ticket);
            projectionRepository.saveAndFlush(projection);
        }
        else throw new TicketNotReservedException();
    }

    @Override
    public void cancelTicket(ProjectionId projectionId, String ticketId) {
        Projections projection = findById(projectionId).orElseThrow(ProjectionNotFoundException::new);
        Ticket ticket = ticketRepository.findById(TicketId.of(ticketId)).orElseThrow();
        if (projection.isTicketAlreadyReserved(ticket)){
            projection.cancelTicket(ticket);
            ticketRepository.saveAndFlush(ticket);
            projectionRepository.saveAndFlush(projection);
        }
        else throw new TicketNotReservedException();
    }

    @Override
    public int availableTickets(ProjectionId projectionId) {
        Projections projection = findById(projectionId).orElseThrow(ProjectionNotFoundException::new);
        return (int) projection.getTickets().stream().filter(Ticket::isReserved).count();
    }
}
