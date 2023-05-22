package emt.movieprojection.xport.rest;

import emt.movieprojection.domain.models.Projections;
import emt.movieprojection.services.ProjectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projections")
public class ProjectionResource {
    private final ProjectionService projectionService;

    public ProjectionResource(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @GetMapping
    public List<Projections> getAll(){
        return projectionService.findAll();
    }
}
