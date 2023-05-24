package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import static io.restassured.RestAssured.given;

public class CinemaControllerTest {

    @Test
    @WithMockUser(roles = "user")
    public void testGetAllCinemasAsUser() {
        given()
                .when()
                .get("http://localhost:8080/api/cinemas")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testGetAllCinemasAsAdmin() {
        given()
                .when()
                .get("http://localhost:8080/api/cinemas")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testGetCinemaByIdAsUser() {
        long cinemaId = 1; // Replace with an existing cinema ID

        given()
                .pathParam("cinemaId", cinemaId)
                .when()
                .get("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testGetCinemaByIdAsAdmin() {
        long cinemaId = 1; // Replace with an existing cinema ID

        given()
                .pathParam("cinemaId", cinemaId)
                .when()
                .get("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testAddCinemaAsUser() {
        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("New Cinema");
        cinema.setAddress("Cinema address");
        cinema.setCapacity(100);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .when()
                .post("http://localhost:8080/api/cinemas")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testAddCinemaAsAdmin() {
        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("New Cinema");
        cinema.setAddress("Cinema address");
        cinema.setCapacity(100);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .when()
                .post("http://localhost:8080/api/cinemas")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testDeleteCinemaAsUser() {
        long cinemaId = 1; // Replace with an existing cinema ID

        given()
                .pathParam("cinemaId", cinemaId)
                .when()
                .delete("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testDeleteCinemaAsAdmin() {
        long cinemaId = 1; // Replace with an existing cinema ID

        given()
                .pathParam("cinemaId", cinemaId)
                .when()
                .delete("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testUpdateCinemaAsUser() {
        long cinemaId = 1; // Replace with an existing cinema ID

        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("Updated Cinema");
        cinema.setAddress("Updated address");
        cinema.setCapacity(150);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .pathParam("cinemaId", cinemaId)
                .when()
                .put("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testUpdateCinemaAsAdmin() {
        long cinemaId = 1; // Replace with an existing cinema ID

        CinemaDTO cinema = new CinemaDTO();
        cinema.setName("Updated Cinema");
        cinema.setAddress("Updated address");
        cinema.setCapacity(150);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(cinema)
                .pathParam("cinemaId", cinemaId)
                .when()
                .put("http://localhost:8080/api/cinemas/{cinemaId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testAddMovieToCinemaAsUser() {
        long cinemaId = 1; // Replace with an existing cinema ID
        long movieId = 1; // Replace with an existing movie ID

        given()
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .put("http://localhost:8080/api/cinemas/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testAddMovieToCinemaAsAdmin() {
        long cinemaId = 1; // Replace with an existing cinema ID
        long movieId = 1; // Replace with an existing movie ID

        given()
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .put("http://localhost:8080/api/cinemas/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @WithMockUser(roles = "user")
    public void testDeleteMovieFromCinemaAsUser() {
        long cinemaId = 1; // Replace with an existing cinema ID
        long movieId = 1; // Replace with an existing movie ID

        given()
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .delete("http://localhost:8080/api/cinemas/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @WithMockUser(roles = "admin")
    public void testDeleteMovieFromCinemaAsAdmin() {
        long cinemaId = 1; // Replace with an existing cinema ID
        long movieId = 1; // Replace with an existing movie ID

        given()
                .pathParam("cinemaId", cinemaId)
                .pathParam("movieId", movieId)
                .when()
                .delete("http://localhost:8080/api/cinemas/{cinemaId}/movies/{movieId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
