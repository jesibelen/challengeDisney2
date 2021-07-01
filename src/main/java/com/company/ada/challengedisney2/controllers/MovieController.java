package com.company.ada.challengedisney2.controllers;

import com.company.ada.challengedisney2.entities.MovieEntity;
import com.company.ada.challengedisney2.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")

public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    private List<MovieEntity> listarAllP(){
        return movieService.listarTodosPelis();
    }


}
