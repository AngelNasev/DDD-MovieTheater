package emt.movieprojection.domain.repository;

import emt.movieprojection.domain.models.ProjectionId;
import emt.movieprojection.domain.models.Projections;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionRepository extends JpaRepository<Projections, ProjectionId> {
}
