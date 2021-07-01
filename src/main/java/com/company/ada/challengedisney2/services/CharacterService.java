package com.company.ada.challengedisney2.services;

import com.company.ada.challengedisney2.entities.CharacterEntity;
import com.company.ada.challengedisney2.repositories.CharacterRepository;
import com.company.ada.challengedisney2.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterService {
    private final CharacterRepository characterRepo;
    private final MovieRepository movieRepo;

    @Autowired
    public CharacterService(CharacterRepository characterRepo, MovieRepository movieRepo) {
        this.characterRepo = characterRepo;
        this.movieRepo = movieRepo;
    }

    public List<Map<String,String>> listarPersonajes(){
        List<Map<String,String>> lista = new ArrayList<>();
        for (CharacterEntity personaje : characterRepo.findAll()){
            lista.add(Map.of("name", personaje.getName(), "image_url", personaje.getImage_url()));
        }
        return lista;
    }

    public void guardarPersonaje(CharacterEntity personaje){
        characterRepo.save(personaje);
    }

    public void borrarPersonaje(Integer id){
        characterRepo.deleteById(id);
    }

    public List<CharacterEntity>listarTodosPersonajes(){
        return characterRepo.findAll();
    }

    public CharacterEntity obtenerPersonajexId(Integer id){
        CharacterEntity personaje = characterRepo.findById(id).orElse(null);
        return personaje;
    }
    public CharacterEntity editarPersonaje(CharacterEntity character){
        CharacterEntity personajeExistente = characterRepo.findById(character.getIdcharacter()).orElse(null);
        if(personajeExistente!=null) {
            if(character.getName()!=null) personajeExistente.setName(character.getName());
            if(character.getAge()!=null) personajeExistente.setAge(character.getAge());
            if(character.getImage_url()!=null) personajeExistente.setImage_url(character.getImage_url());
            if(character.getStory()!=null) personajeExistente.setStory(character.getStory());
            if(character.getWeight()!=null) personajeExistente.setWeight(character.getWeight());

            return characterRepo.save(personajeExistente);
        }else return null;
    }

    public List<CharacterEntity> search(String nombre){
        List<CharacterEntity> characters= characterRepo.findCharacterEntityByNameContaining(nombre);
        return characters;
    }

    public List<CharacterEntity> searchAge(Integer edad) {
        List<CharacterEntity> characters= characterRepo.findCharacterEntityByAge(edad);
        return characters;
    }


    /*public void remove(Integer id){
        CharacterEntity personaje= characterRepo.findById(id).orElse(null);
        List<MovieEntity> movies= personaje.getMovies();

        characterRepo.delete(personaje);
    }*/

}
