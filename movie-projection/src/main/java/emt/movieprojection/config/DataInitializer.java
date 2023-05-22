package emt.movieprojection.config;

import emt.movieprojection.domain.models.*;
import emt.movieprojection.domain.repository.MovieRepository;
import emt.movieprojection.domain.repository.MovieTheaterRepository;
import emt.movieprojection.domain.repository.ProjectionRepository;
import emt.shared_kernel.domain.financial.Currency;
import emt.shared_kernel.domain.financial.Money;
import emt.shared_kernel.domain.personal.PersonName;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final ProjectionRepository projectionRepository;
    private final MovieTheaterRepository movieTheaterRepository;
    private final MovieRepository movieRepository;


    public DataInitializer(ProjectionRepository projectionRepository, MovieTheaterRepository movieTheaterRepository, MovieRepository movieRepository) {
        this.projectionRepository = projectionRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void initData() {
        MovieTheaters movieTheater = MovieTheaters.build("Movie Theater 1",50);
        if (movieTheaterRepository.findAll().isEmpty()){
            movieTheaterRepository.saveAndFlush(movieTheater);
        }
        Movies movie = Movies.build("movie name",Genre.DRAMA, PersonName.valueOf("John","Smith"),120);
        if (movieRepository.findAll().isEmpty()){
            movieRepository.saveAndFlush(movie);
        }
        Projections projection = new Projections(movieTheater.getId(),Money.valueOf(Currency.MKD,300),movie.getId(),LocalDateTime.now());
        List<Ticket> tickets=new ArrayList<>();
        for (int i=0;i<movieTheater.getCapacity();i++){
            tickets.add(new Ticket(i+1,projection.getTicketPrice(),false));
        }
        projection.addTickets(tickets);
        projection.reserveTicket(tickets.get(0));
        projection.reserveTicket(tickets.get(1));
        if (projectionRepository.findAll().isEmpty()){
            projectionRepository.saveAndFlush(projection);
        }
    }

}
