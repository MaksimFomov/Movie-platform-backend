package com.fomov.movieplatform.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_details")
public class MovieDetails {
    @Id
    @Column(name = "movie_id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "age_limit", nullable = false)
    private Integer ageLimit;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public MovieDetails() {
    }

    public MovieDetails(Long id, String description, String country, Integer year, String producer, Integer duration, Integer ageLimit, Movie movie) {
        this.id = id;
        this.description = description;
        this.country = country;
        this.year = year;
        this.producer = producer;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetails that = (MovieDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(country, that.country) && Objects.equals(year, that.year) && Objects.equals(producer, that.producer) && Objects.equals(duration, that.duration) && Objects.equals(ageLimit, that.ageLimit) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, country, year, producer, duration, ageLimit, movie);
    }
}
