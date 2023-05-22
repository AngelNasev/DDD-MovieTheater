package emt.movieprojection.services;

import emt.movieprojection.domain.models.*;
import emt.movieprojection.services.form.ProjectionForm;

import java.util.List;
import java.util.Optional;

public interface ProjectionService {
    ProjectionId createProjection(ProjectionForm projectionForm);
    List<Projections> findAll();
    Optional<Projections> findById(ProjectionId projectionId);
    void reserveTicket(ProjectionId projectionId, String ticketId);
    void cancelTicket(ProjectionId projectionId, String ticketId);
    int availableTickets(ProjectionId projectionId);
}
