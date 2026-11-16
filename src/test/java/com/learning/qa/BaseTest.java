package com.learning.qa;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String BASE_URL = "https://reqres.in/api";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
