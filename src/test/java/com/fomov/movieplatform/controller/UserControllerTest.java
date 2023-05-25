package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserControllerTest {

    private static final String BASE_URL = "http://localhost:8080/api/users";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void testRegisterUser() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername("newuser");
        userRequestDTO.setPassword("newpassword");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(userRequestDTO)
                .when()
                .post(BASE_URL + "/register")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void testRegisterUserUsernameExists() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername(USER_USERNAME);
        userRequestDTO.setPassword("newpassword");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(userRequestDTO)
                .when()
                .post(BASE_URL + "/register")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testLoginUser() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername(USER_USERNAME);
        userRequestDTO.setPassword(USER_PASSWORD);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(userRequestDTO)
                .when()
                .post(BASE_URL + "/login")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testLoginUserInvalidCredentials() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername(USER_USERNAME);
        userRequestDTO.setPassword("invalidpassword");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(userRequestDTO)
                .when()
                .post(BASE_URL + "/login")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void testGetAllUsersAsUser() {
        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllUsersAsAdmin() {
        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetUserByIdAsUser() {
        long userId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("userId", userId)
                .when()
                .get(BASE_URL + "/{userId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetUserByIdAsAdmin() {
        long userId = 1;

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .pathParam("userId", userId)
                .when()
                .get(BASE_URL + "/{userId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetUserByIdNotFound() {
        long userId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("userId", userId)
                .when()
                .get(BASE_URL + "/{userId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testUpdatePassword() {
        long userId = 1;

        Map<String, String> newPasswordMap = new HashMap<>();
        newPasswordMap.put("password", "newpassword");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(newPasswordMap)
                .when()
                .put(BASE_URL + "/{userId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testUpdatePasswordUserNotFound() {
        long userId = 999;

        Map<String, String> newPasswordMap = new HashMap<>();
        newPasswordMap.put("password", "newpassword");

        given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(newPasswordMap)
                .when()
                .put(BASE_URL + "/{userId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddOrder() {
        long userId = 1;
        long eventId = 1;

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUserId(userId);
        orderRequestDTO.setEventId(eventId);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(orderRequestDTO)
                .when()
                .post(BASE_URL + "/{userId}/orders")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testAddOrderUserNotFound() {
        long userId = 999;
        long eventId = 1;

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUserId(userId);
        orderRequestDTO.setEventId(eventId);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(orderRequestDTO)
                .when()
                .post(BASE_URL + "/{userId}/orders")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddOrderEventNotFound() {
        long userId = 1;
        long eventId = 999;

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUserId(userId);
        orderRequestDTO.setEventId(eventId);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(orderRequestDTO)
                .when()
                .post(BASE_URL + "/{userId}/orders")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testAddOrderNoTickets() {
        long userId = 1;
        long eventId = 1;

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUserId(userId);
        orderRequestDTO.setEventId(eventId);

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("userId", userId)
                .body(orderRequestDTO)
                .when()
                .post(BASE_URL + "/{userId}/orders")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testCancelOrder() {
        long userId = 1;
        long orderId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("userId", userId)
                .pathParam("orderId", orderId)
                .when()
                .delete(BASE_URL + "/{userId}/orders/{orderId}")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testCancelOrderUserNotFound() {
        long userId = 999;
        long orderId = 1;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("userId", userId)
                .pathParam("orderId", orderId)
                .when()
                .delete(BASE_URL + "/{userId}/orders/{orderId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testCancelOrderEventNotFound() {
        long userId = 1;
        long orderId = 999;

        given()
                .auth().basic(USER_USERNAME, USER_PASSWORD)
                .pathParam("userId", userId)
                .pathParam("orderId", orderId)
                .when()
                .delete(BASE_URL + "/{userId}/orders/{orderId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}

