package emt.movieprojection.domain.repository;


import emt.movieprojection.domain.models.MovieId;
import emt.movieprojection.domain.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies, MovieId> {
}
