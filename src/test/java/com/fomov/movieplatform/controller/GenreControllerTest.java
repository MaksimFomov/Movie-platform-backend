package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.GenreDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class GenreControllerTest {

    private static final String BASE_URL = "http://localhost:8080/api/genres";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testGetAllGenresAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllGenresAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetGenreByIdAsUser() {
        long genreId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .get(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetGenreByIdAsAdmin() {
        long genreId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .get(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetGenreByIdNotFound() {
        long genreId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .get(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddGenreAsUser() {
        GenreDTO genre = new GenreDTO();
        genre.setName("Action");

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(genre)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testAddGenreAsAdmin() {
        GenreDTO genre = new GenreDTO();
        genre.setName("Action");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(genre)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void testUpdateGenreAsUser() {
        long genreId = 1;
        GenreDTO genre = new GenreDTO();
        genre.setName("Comedy");

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(genre)
                .pathParam("genreId", genreId)
                .when()
                .put(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testUpdateGenreAsAdmin() {
        long genreId = 1;
        GenreDTO genre = new GenreDTO();
        genre.setName("Comedy");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(genre)
                .pathParam("genreId", genreId)
                .when()
                .put(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testUpdateGenreNotFound() {
        long genreId = 999;
        GenreDTO genre = new GenreDTO();
        genre.setName("Comedy");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(genre)
                .pathParam("genreId", genreId)
                .when()
                .put(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testDeleteGenreAsUser() {
        long genreId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .delete(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testDeleteGenreAsAdmin() {
        long genreId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .delete(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteGenreNotFound() {
        long genreId = 999;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("genreId", genreId)
                .when()
                .delete(BASE_URL + "/{genreId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}

