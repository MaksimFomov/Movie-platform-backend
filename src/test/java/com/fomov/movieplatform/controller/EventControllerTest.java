package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.EventRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

public class EventControllerTest {
    private static final String BASE_URL = "http://localhost:8080/api/events";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testGetAllEventsAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllEventsAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventByIdAsUser() {
        long eventId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .get(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventByIdAsAdmin() {
        long eventId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .get(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventNotFound() {
        long eventId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .get(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddEventAsUser() {
        EventRequestDTO event = new EventRequestDTO();
        event.setMovieId(1);
        event.setCinemaId(1);
        event.setEventDateTime(LocalDateTime.now());
        event.setPrice(10.0);
        event.setNumberOfTickets(100);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(event)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testAddEventAsAdmin() {
        EventRequestDTO event = new EventRequestDTO();
        event.setMovieId(1);
        event.setCinemaId(1);
        event.setEventDateTime(LocalDateTime.now());
        event.setPrice(10.0);
        event.setNumberOfTickets(100);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(event)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void testUpdateEventAsUser() {
        long eventId = 1;
        EventRequestDTO event = new EventRequestDTO();
        event.setMovieId(1);
        event.setCinemaId(1);
        event.setEventDateTime(LocalDateTime.now());
        event.setPrice(15.0);
        event.setNumberOfTickets(200);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("eventId", eventId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(event)
                .when()
                .put(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testUpdateEventAsAdmin() {
        long eventId = 1;
        EventRequestDTO event = new EventRequestDTO();
        event.setMovieId(1);
        event.setCinemaId(1);
        event.setEventDateTime(LocalDateTime.now());
        event.setPrice(15.0);
        event.setNumberOfTickets(200);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("eventId", eventId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(event)
                .when()
                .put(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    public void testUpdateEventNotFound() {
        long eventId = 999;
        EventRequestDTO event = new EventRequestDTO();
        event.setMovieId(1);
        event.setCinemaId(1);
        event.setEventDateTime(LocalDateTime.now());
        event.setPrice(15.0);
        event.setNumberOfTickets(200);

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("eventId", eventId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(event)
                .when()
                .put(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testDeleteEventAsUser() {
        long eventId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .delete(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    public void testDeleteEventAsAdmin() {
        long eventId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .delete(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteEventNotFound() {
        long eventId = 999;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("eventId", eventId)
                .when()
                .delete(BASE_URL + "/{eventId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testGetAllEventsSortedByDateAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL + "/sorted-by-date")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllEventsSortedByDateAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL + "/sorted-by-date")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByCinemaAsUser() {
        long cinemaId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .get(BASE_URL + "/cinema/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByCinemaAsAdmin() {
        long cinemaId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("cinemaId", cinemaId)
                .when()
                .get(BASE_URL + "/cinema/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByMovieIdAsUser() {
        long movieId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .get(BASE_URL + "/movie/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByMovieIdAsAdmin() {
        long movieId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("movieId", movieId)
                .when()
                .get(BASE_URL + "/movie/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByGenreAsUser() {
        String genreName = "Action";

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("genreName", genreName)
                .when()
                .get(BASE_URL + "/genre/{genreName}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetEventsByGenreAsAdmin() {
        String genreName = "Action";

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("genreName", genreName)
                .when()
                .get(BASE_URL + "/genre/{genreName}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}

