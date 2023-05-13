package com.fomov.movieplatform.repository;

import com.fomov.movieplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
