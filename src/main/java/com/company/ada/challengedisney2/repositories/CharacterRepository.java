package com.company.ada.challengedisney2.repositories;

import com.company.ada.challengedisney2.entities.CharacterEntity;
import com.company.ada.challengedisney2.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    List<CharacterEntity>findCharacterEntityByNameContaining(String name);
    List<CharacterEntity>findCharacterEntityByAge(Integer age);
}
