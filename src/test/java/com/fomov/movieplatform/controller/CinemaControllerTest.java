package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class CinemaControllerTest {
    private static final String BASE_URL = "http://localhost:8080/api/cinemas";
    private static final String USER_USERNAME = "user1";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testGetAllCinemasAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllCinemasAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetCinemaByIdAsUser() {
        long cinemaId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .get(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetCinemaByIdAsAdmin() {
        long cinemaId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .get(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetCinemaByIdNotFound() {
        long cinemaId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .get(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddCinemaAsUser() {
        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("New Cinema");
        cinema.setAddress("Cinema address");
        cinema.setCapacity(100);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testAddCinemaAsAdmin() {
        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("New Cinema");
        cinema.setAddress("Cinema address");
        cinema.setCapacity(100);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void testUpdateCinemaAsUser() {
        long cinemaId = 1;

        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("Updated Cinema");
        cinema.setAddress("Updated address");
        cinema.setCapacity(150);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .pathParam("cinemaId", cinemaId)
                .when()
                .put(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testUpdateCinemaAsAdmin() {
        long cinemaId = 1;

        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("Updated Cinema");
        cinema.setAddress("Updated address");
        cinema.setCapacity(150);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .pathParam("cinemaId", cinemaId)
                .when()
                .put(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testUpdateCinemaNotFound() {
        long cinemaId = 999;

        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("Updated Cinema");
        cinema.setAddress("Updated address");
        cinema.setCapacity(150);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .pathParam("cinemaId", cinemaId)
                .when()
                .put(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testDeleteCinemaAsUser() {
        long cinemaId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .delete(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testDeleteCinemaAsAdmin() {
        long cinemaId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .delete(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteCinemaNotFound() {
        long cinemaId = 999;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .delete(BASE_URL + "/{cinemaId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddMovieToCinemaAsUser() {
        long cinemaId = 1;
        long movieId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .put(BASE_URL + "/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testAddMovieToCinemaAsAdmin() {
        long cinemaId = 1;
        long movieId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .put(BASE_URL + "/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteMovieFromCinemaAsUser() {
        long cinemaId = 1;
        long movieId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .delete(BASE_URL + "/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testDeleteMovieFromCinemaAsAdmin() {
        long cinemaId = 1;
        long movieId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .delete(BASE_URL + "/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
