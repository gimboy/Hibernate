package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int age;
    @ManyToOne
    @JoinColumn(name = "director_id",referencedColumnName = "director_id")
    private Director director;

    public Movie(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Movie() {
    }

    public Movie(String name, int age, Director director) {
        this.name = name;
        this.age = age;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie(int id, String name, int age, Director director) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.director = director;
    }

    @Override
    public String toString() {
        return name;
    }
}
