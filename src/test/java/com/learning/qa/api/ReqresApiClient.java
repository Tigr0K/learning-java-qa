package com.learning.qa.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class ReqresApiClient implements ApiClient {

    private final String baseUrl;
    private final RequestSpecification spec;

    public ReqresApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.spec = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
    }

    @Override
    public Response getUser(int id) {
        return spec
                .pathParam("id", id)
                .when()
                .get(baseUrl + "/users/{id}");
    }

    @Override
    public Response listUsers(int page, int perPage) {
        return spec
                .queryParam("page", page)
                .queryParam("per_page", perPage)
                .when()
                .get(baseUrl + "/users");
    }

    @Override
    public Response createUser(String name, String job) {
        String body =  String.format("{\"name\":\"%s\",\"job\":\"%s\"}", name, job);
        return spec
                .body(body)
                .when()
                .post(baseUrl + "/users");
    }

    @Override
    public Response deleteUser(int id) {
        return spec
                .pathParam("id", id)
                .when()
                .delete(baseUrl + "/users/{id}");
    }

    @Override
    public Response listResources() {
        return spec
                .when()
                .get(baseUrl + "/unknown");
    }
}