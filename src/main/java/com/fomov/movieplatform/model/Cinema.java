package com.fomov.movieplatform.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "cinema",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CinemaDetails cinemaDetails;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "cinema_movie",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    @OneToMany(mappedBy = "cinema",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Event> events;

    public Cinema() {
    }

    public Cinema(String name, CinemaDetails cinemaDetails, List<Movie> movies, List<Event> events) {
        this.name = name;
        this.cinemaDetails = cinemaDetails;
        this.movies = movies;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CinemaDetails getCinemaDetails() {
        return cinemaDetails;
    }

    public void setCinemaDetails(CinemaDetails cinemaDetails) {
        this.cinemaDetails = cinemaDetails;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(name, cinema.name) && Objects.equals(cinemaDetails, cinema.cinemaDetails) && Objects.equals(movies, cinema.movies) && Objects.equals(events, cinema.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cinemaDetails, movies, events);
    }
}
