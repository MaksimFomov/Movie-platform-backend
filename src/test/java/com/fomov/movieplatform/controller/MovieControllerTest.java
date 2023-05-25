package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.MovieDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class MovieControllerTest {

    private static final String BASE_URL = "http://localhost:8080/api/movies";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testGetAllMoviesAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllMoviesAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetMovieByIdAsUser() {
        long movieId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .get(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetMovieByIdAsAdmin() {
        long movieId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .get(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetMovieByIdNotFound() {
        long movieId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .get(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddMovieAsUser() {
        MovieDTO movie = new MovieDTO();
        movie.setName("Movie 1");
        movie.setDescription("Description 1");
        movie.setCountry("Country 1");
        movie.setYear(2021);
        movie.setProducer("Producer 1");
        movie.setDuration(120);
        movie.setAgeLimit(16);
        movie.setGenreName("Genre 1");

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testAddMovieAsAdmin() {
        MovieDTO movie = new MovieDTO();
        movie.setName("Movie 1");
        movie.setDescription("Description 1");
        movie.setCountry("Country 1");
        movie.setYear(2021);
        movie.setProducer("Producer 1");
        movie.setDuration(120);
        movie.setAgeLimit(16);
        movie.setGenreName("Genre 1");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void testDeleteMovieAsUser() {
        long movieId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .delete(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testDeleteMovieAsAdmin() {
        long movieId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .delete(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteMovieNotFound() {
        long movieId = 999;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .delete(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testUpdateMovieAsUser() {
        long movieId = 1;
        MovieDTO movie = new MovieDTO();
        movie.setName("Updated Movie");

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .pathParam("movieId", movieId)
                .when()
                .put(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testUpdateMovieAsAdmin() {
        long movieId = 1;
        MovieDTO movie = new MovieDTO();
        movie.setName("Updated Movie");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .pathParam("movieId", movieId)
                .when()
                .put(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testUpdateMovieNotFound() {
        long movieId = 999;
        MovieDTO movie = new MovieDTO();
        movie.setName("Updated Movie");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .pathParam("movieId", movieId)
                .when()
                .put(BASE_URL + "/{movieId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}

