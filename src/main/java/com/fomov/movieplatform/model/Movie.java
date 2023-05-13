package com.fomov.movieplatform.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "movie",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CinemaDetails cinemaDetails;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToMany(mappedBy = "movies",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Cinema> cinemas;

    @OneToMany(mappedBy = "movie",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Event> events;

    public Movie() {
    }

    public Movie(String name, CinemaDetails cinemaDetails, Genre genre, List<Cinema> cinemas, List<Event> events) {
        this.name = name;
        this.cinemaDetails = cinemaDetails;
        this.genre = genre;
        this.cinemas = cinemas;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
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
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(cinemaDetails, movie.cinemaDetails) && Objects.equals(genre, movie.genre) && Objects.equals(cinemas, movie.cinemas) && Objects.equals(events, movie.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cinemaDetails, genre, cinemas, events);
    }
}
