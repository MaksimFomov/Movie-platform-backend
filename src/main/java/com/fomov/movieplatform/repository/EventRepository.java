package com.fomov.movieplatform.repository;

import com.fomov.movieplatform.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<List<Event>> findAllByCinemaId(Long cinemaId);
    Optional<List<Event>> findAllByMovieId(Long movieId);
    Optional<List<Event>> findAllByMovieGenre_Name(String genreName);
}
