package com.company.ada.challengedisney2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcharacter;
    private String image_url;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;
    //@JsonManagedReference
    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "characters_x_movies", joinColumns = @JoinColumn(name = "idcharacter"), inverseJoinColumns = @JoinColumn(name = "idmovie"))
    private List<MovieEntity> movies;



    public CharacterEntity() {
    }

    public CharacterEntity(Integer idcharacter, String image_url, String name, Integer age, Integer weight, String story, List<MovieEntity> movies) {
        this.idcharacter = idcharacter;
        this.image_url = image_url;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }

    public CharacterEntity(String image_url, String name, Integer age, Integer weight, String story, List<MovieEntity> movies) {
        this.image_url = image_url;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }

    public Integer getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(Integer idcharacter) {
        this.idcharacter = idcharacter;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "idcharacter=" + idcharacter +
                ", image_url='" + image_url + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", story='" + story + '\'' +
                ", movies=" + movies +
                '}';
    }
}
