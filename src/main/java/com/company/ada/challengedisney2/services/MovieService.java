package com.company.ada.challengedisney2.services;

import com.company.ada.challengedisney2.entities.CharacterEntity;
import com.company.ada.challengedisney2.entities.MovieEntity;
import com.company.ada.challengedisney2.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final MovieRepository movieRepo;
    @Autowired
    public MovieService(MovieRepository movieRepo){
        this.movieRepo=movieRepo;
    }
    public List<MovieEntity>listarTodosPelis(){
        return movieRepo.findAll();
    }

    /*
        STRING (imagen), STRING (titulo), INTEGER (fecha creacion)
        string / string
        string / string
        string /integer

    */
    //OPCION A
    public List<Map<String,String>> listarPelis(){
        List<Map<String,String>> listMovie = new ArrayList<>();
        for(MovieEntity peli: movieRepo.findAll()){
            listMovie.add(Map.of("image_url",peli.getImage_url(),"title", peli.getTitulo(),"year",String.valueOf(peli.getYear())));
        }
        return listMovie;
    }
    //No funca OPCION B :-(
    public List<MovieEntity> listTest(){
        List<MovieEntity> movies = new ArrayList<>();

        for (MovieEntity peli: movieRepo.findAll()){
            MovieEntity peliAux = new MovieEntity(peli.getImage_url(), peli.getTitulo(), peli.getYear());
            movies.add(peliAux);
        }
        return movies;
    }



}
