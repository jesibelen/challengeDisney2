package com.company.ada.challengedisney2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idmovie;
    private String image_url;
    private String titulo;
    private Integer year;
    private Integer score;

    @JsonBackReference
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<CharacterEntity> characters;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<GenreEntity> genres;

    public MovieEntity() { }


    public Integer getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Integer idmovie) {
        this.idmovie = idmovie;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }
}
