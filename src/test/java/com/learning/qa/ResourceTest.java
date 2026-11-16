package com.learning.qa;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResourceTest extends BaseTest{
@Test
    void shouldGetUnknownResources(){
    given()
            .when()
            .get("/unknown")
            .then()
            .statusCode(200)
            .body("data.size()", equalTo(6))
            .body("total", equalTo(12));
}
}
