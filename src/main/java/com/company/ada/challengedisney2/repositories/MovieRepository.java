package com.company.ada.challengedisney2.repositories;

import com.company.ada.challengedisney2.entities.CharacterEntity;
import com.company.ada.challengedisney2.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    List<MovieEntity>findMovieEntityByCharactersEquals(CharacterEntity personaje);
}
