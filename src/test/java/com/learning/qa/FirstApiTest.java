package com.learning.qa;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

// extends BaseTest — наследуемся, получаем BASE_URL и setup()
public class FirstApiTest extends BaseTest {

    @Test
    void shouldGetSingleUser() {
        given()                              // 1. настройки запроса (пока пусто)
                .when()                          // 2. сам запрос
                .get("/users/2")             //    GET https://reqres.in/api/users/2
                .then()                          // 3. проверки ответа
                .statusCode(200)             //    статус 200 OK
                .body("data.id", equalTo(2)) //    в ответе data.id == 2
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    void shouldReturn404ForMissingUser() {
        given()
                .when()
                .get("/users/9999")          // пользователя 9999 не существует
                .then()
                .statusCode(404);            // ожидаем 404
    }
    @Test
    void shouldGetUserList() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data.size()", equalTo(6));
    }
}
