package com.fomov.movieplatform.repository;

import com.fomov.movieplatform.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
