package com.fomov.movieplatform.repository;

import com.fomov.movieplatform.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
