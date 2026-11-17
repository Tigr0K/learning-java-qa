package com.learning.qa;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.requestSpecification;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static final String BASE_URL = "https://reqres.in/api";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
        requestSpecification = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Accept", "application/json");
    }

}
