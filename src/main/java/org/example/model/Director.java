package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "director")
    private List<Movie> movieList;

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Director(String name, int age, List<Movie> movieList) {
        this.name = name;
        this.age = age;
        this.movieList = movieList;
    }

    public Director() {
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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", movieList=" + movieList +
                '}';
    }

    public Director(int id, String name, int age, List<Movie> movieList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.movieList = movieList;
    }
}
