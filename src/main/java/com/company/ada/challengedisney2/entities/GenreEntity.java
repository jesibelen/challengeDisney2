package com.company.ada.challengedisney2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenreEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgenre;
    private String nombre;
    private String image_url;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "genres_x_movies",
            joinColumns = @JoinColumn(name = "idgenre"),
            inverseJoinColumns = @JoinColumn(name = "idmovie"))
    private List<MovieEntity> movies;

    public GenreEntity(){}

    public Integer getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(Integer idgenre) {
        this.idgenre = idgenre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movieEntities) {
        this.movies = movieEntities;
    }
}
