package com.fomov.movieplatform.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class OrderControllerTest {

    private static final String BASE_URL = "http://localhost:8080/api/orders";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testGetAllOrdersAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllOrdersAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetOrderByIdAsUser() {
        long orderId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("orderId", orderId)
                .when()
                .get(BASE_URL + "/{orderId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetOrderByIdAsAdmin() {
        long orderId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("orderId", orderId)
                .when()
                .get(BASE_URL + "/{orderId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetOrderByIdNotFound() {
        long orderId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("orderId", orderId)
                .when()
                .get(BASE_URL + "/{orderId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}

