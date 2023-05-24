package com.fomov.movieplatform.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(name = "eventDateTime", nullable = false)
    private LocalDateTime eventDateTime;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "number_of_tickets", nullable = false)
    private Integer numberOfTickets;

    @OneToMany(mappedBy = "event",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Order> orders;

    public Event() {
    }

    public Event(Long id, Movie movie, Cinema cinema, LocalDateTime eventDateTime, Double price, Integer numberOfTickets, List<Order> orders) {
        this.id = id;
        this.movie = movie;
        this.cinema = cinema;
        this.eventDateTime = eventDateTime;
        this.price = price;
        this.numberOfTickets = numberOfTickets;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(movie, event.movie) && Objects.equals(cinema, event.cinema) && Objects.equals(eventDateTime, event.eventDateTime) && Objects.equals(price, event.price) && Objects.equals(numberOfTickets, event.numberOfTickets) && Objects.equals(orders, event.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, cinema, eventDateTime, price, numberOfTickets, orders);
    }
}
