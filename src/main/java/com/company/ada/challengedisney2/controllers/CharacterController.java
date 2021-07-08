package com.company.ada.challengedisney2.controllers;

import com.company.ada.challengedisney2.entities.CharacterEntity;
import com.company.ada.challengedisney2.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterServ;
    @Autowired
    public CharacterController(CharacterService characterServ) {
        this.characterServ = characterServ;
    }

    @GetMapping
    private List<Map<String,String>> listarPersonajes(){
        return characterServ.listarPersonajes();
    }
    @GetMapping("/all")
    private List<CharacterEntity> listarTodosPersonajes(){
        return characterServ.listarTodosPersonajes();
    }

    @GetMapping("/{id}")
    private CharacterEntity getPersonajeById(@PathVariable Integer id){
        return characterServ.obtenerPersonajexId(id);
    }

    @PostMapping(path="/save", consumes = "application/json")
    private void save(@RequestBody CharacterEntity personaje){
        characterServ.guardarPersonaje(personaje);
    }

    @DeleteMapping("/borrar/{id}")
    private void delate(@PathVariable Integer id){
        characterServ.borrarPersonaje(id);
    }

    @PutMapping("/update")
    private CharacterEntity editarProducto(@RequestBody CharacterEntity personaje){
        return characterServ.editarPersonaje(personaje);
    }

    @GetMapping("/search")
    private List<CharacterEntity> search(@RequestParam String nombre){
        return characterServ.search(nombre);
    }

    @GetMapping("/searchage")
    private List<CharacterEntity> searchAge(@RequestParam Integer edad){
        return characterServ.searchAge(edad);
    }




    /*@DeleteMapping("borrar2/{id}")
    private void borrar2(@PathVariable Integer id){
        characterServ.remove(id);
    }*/
}
