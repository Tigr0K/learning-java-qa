package com.learning.qa;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class UserApiTest extends BaseTest{
    @Test
    void shouldGetUsersWithQueryParams() {
        given()
                .queryParam("page", 2)
                .queryParam("per_page", 3)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("per_page", equalTo(3))
                .body("data.size()", equalTo(3));
    }

    @Test
    void shouldGetUserWithPathParam() {
        given()
                .pathParam("id", 7)
                .when()
                .get("/users/{id}")
                .then()
                .log().ifValidationFails()      // лог только при падении
                .statusCode(200)
                .body("data.id", equalTo(7));
    }

    @Test
    void shouldReturnTotalPagesGreaterThanOne(){
        given()
                .log().ifValidationFails()
                .when()
                .get("/unknown")
                .then()
                .statusCode(200)
                .body("total_pages", greaterThan(1));
    }
}
