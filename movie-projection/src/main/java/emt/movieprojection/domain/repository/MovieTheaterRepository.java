package emt.movieprojection.domain.repository;


import emt.movieprojection.domain.models.MovieTheaterId;
import emt.movieprojection.domain.models.MovieTheaters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterRepository extends JpaRepository<MovieTheaters, MovieTheaterId> {
}
