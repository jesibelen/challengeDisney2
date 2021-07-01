package com.company.ada.challengedisney2.services;

import com.company.ada.challengedisney2.entities.MovieEntity;
import com.company.ada.challengedisney2.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<MovieEntity> listarPelis(){
        List<MovieEntity> lista = new ArrayList<>();
        for(MovieEntity movie: movieRepo.findAll()){
           // MovieEntity movieAux= new MovieEntity(movie.getImage_url(),movie.getTitulo());
          //  lista.add(movieAux);
        }
        return lista;
    }



}
