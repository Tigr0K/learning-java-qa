package com.learning.qa.api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class FakeApiClient implements ApiClient{

    @Override
    public Response getUser(int id) {
        return new ResponseBuilder()
                .setStatusCode(200)
                .setBody( String.format("{\"id\": \"%s\", \"name\": \"Иван Иванов\"}", id))
                .build();
    }

    @Override
    public Response listUsers(int page, int perPage) {
        return new ResponseBuilder()
                .setStatusCode(200)
                .setBody(String.format("{\n" +
                        "    \"page\": %s,\n" +
                        "    \"per_page\": %s,\n" +
                        "    \"total\": 12,\n" +
                        "    \"total_pages\": 4,\n" +
                        "    \"data\": [\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"email\": \"eve.holt@reqres.in\",\n" +
                        "            \"first_name\": \"Eve\",\n" +
                        "            \"last_name\": \"Holt\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/4-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"email\": \"charles.morris@reqres.in\",\n" +
                        "            \"first_name\": \"Charles\",\n" +
                        "            \"last_name\": \"Morris\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"email\": \"tracey.ramos@reqres.in\",\n" +
                        "            \"first_name\": \"Tracey\",\n" +
                        "            \"last_name\": \"Ramos\",\n" +
                        "            \"avatar\": \"https://reqres.in/img/faces/6-image.jpg\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://reqres.in/go/clerk\",\n" +
                        "        \"text\": \"Your AI coding agent can add authentication and user management to your app with Clerk. Point it to clerk.com/SKILL.md and get building.\",\n" +
                        "        \"sponsored_by\": \"Clerk\"\n" +
                        "    },\n" +
                        "    \"_meta\": {\n" +
                        "        \"powered_by\": \"ReqRes\",\n" +
                        "        \"docs_url\": \"https://reqres.in/docs\",\n" +
                        "        \"upgrade_url\": \"https://app.reqres.in/upgrade\",\n" +
                        "        \"example_url\": \"https://reqres.in/docs#example-app\",\n" +
                        "        \"variant\": \"key_v1\",\n" +
                        "        \"message\": \"You are on the shared demo (no personal key), which has a low daily limit. A free account gives you your own key with 250 requests a day, plus request logs and your own collections.\",\n" +
                        "        \"cta\": {\n" +
                        "            \"label\": \"Get a free key\",\n" +
                        "            \"url\": \"https://app.reqres.in/?utm_source=reqres_api&utm_medium=json&utm_campaign=demo_meta_key\"\n" +
                        "        },\n" +
                        "        \"context\": \"keyless_success\"\n" +
                        "    }\n" +
                        "}", page, perPage))
                .build();
    }

    @Override
    public Response createUser(String name, String job) {
        return new ResponseBuilder()
                .setStatusCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody( String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"job\": \"%s\",\n" +
                        "    \"id\": \"605\",\n" +
                        "    \"createdAt\": \"2026-11-25T19:11:16.754Z\",\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://reqres.in/go/clerk\",\n" +
                        "        \"text\": \"Your AI coding agent can add authentication and user management to your app with Clerk. Point it to clerk.com/SKILL.md and get building.\",\n" +
                        "        \"sponsored_by\": \"Clerk\"\n" +
                        "    },\n" +
                        "    \"_meta\": {\n" +
                        "        \"powered_by\": \"ReqRes\",\n" +
                        "        \"docs_url\": \"https://reqres.in/docs\",\n" +
                        "        \"upgrade_url\": \"https://app.reqres.in/upgrade\",\n" +
                        "        \"example_url\": \"https://reqres.in/docs#example-app\",\n" +
                        "        \"variant\": \"key_v1\",\n" +
                        "        \"message\": \"You are on the shared demo (no personal key), which has a low daily limit. A free account gives you your own key with 250 requests a day, plus request logs and your own collections.\",\n" +
                        "        \"cta\": {\n" +
                        "            \"label\": \"Get a free key\",\n" +
                        "            \"url\": \"https://app.reqres.in/?utm_source=reqres_api&utm_medium=json&utm_campaign=demo_meta_key\"\n" +
                        "        },\n" +
                        "        \"context\": \"keyless_success\",\n" +
                        "        \"persisted\": false,\n" +
                        "        \"persistence\": \"Demo endpoints echo writes without saving them. For data that persists, create a free project with POST https://reqres.in/api/projects/sandbox (no signup).\"\n" +
                        "    }\n" +
                        "}", name, job))
                .build();
    }

    @Override
    public Response deleteUser(int id) {
        return new ResponseBuilder()
                .setStatusCode(204)
                .build();
    }

    @Override
    public Response listResources() {
        return new ResponseBuilder()
                .setStatusCode(200)
                .setBody("{\n" +
                        "    \"page\": 1,\n" +
                        "    \"per_page\": 6,\n" +
                        "    \"total\": 12,\n" +
                        "    \"total_pages\": 2,\n" +
                        "    \"data\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"cerulean\",\n" +
                        "            \"year\": 2000,\n" +
                        "            \"color\": \"#98B2D1\",\n" +
                        "            \"pantone_value\": \"15-4020\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"fuchsia rose\",\n" +
                        "            \"year\": 2001,\n" +
                        "            \"color\": \"#C74375\",\n" +
                        "            \"pantone_value\": \"17-2031\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 3,\n" +
                        "            \"name\": \"true red\",\n" +
                        "            \"year\": 2002,\n" +
                        "            \"color\": \"#BF1932\",\n" +
                        "            \"pantone_value\": \"19-1664\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"name\": \"aqua sky\",\n" +
                        "            \"year\": 2003,\n" +
                        "            \"color\": \"#7BC4C4\",\n" +
                        "            \"pantone_value\": \"14-4811\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"name\": \"tigerlily\",\n" +
                        "            \"year\": 2004,\n" +
                        "            \"color\": \"#E2583E\",\n" +
                        "            \"pantone_value\": \"17-1456\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"name\": \"blue turquoise\",\n" +
                        "            \"year\": 2005,\n" +
                        "            \"color\": \"#53B0AE\",\n" +
                        "            \"pantone_value\": \"15-5217\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"support\": {\n" +
                        "        \"url\": \"https://reqres.in/go/clerk\",\n" +
                        "        \"text\": \"Your AI coding agent can add authentication and user management to your app with Clerk. Point it to clerk.com/SKILL.md and get building.\",\n" +
                        "        \"sponsored_by\": \"Clerk\"\n" +
                        "    },\n" +
                        "    \"_meta\": {\n" +
                        "        \"powered_by\": \"ReqRes\",\n" +
                        "        \"docs_url\": \"https://reqres.in/docs\",\n" +
                        "        \"upgrade_url\": \"https://app.reqres.in/upgrade\",\n" +
                        "        \"example_url\": \"https://reqres.in/docs#example-app\",\n" +
                        "        \"variant\": \"key_v1\",\n" +
                        "        \"message\": \"You are on the shared demo (no personal key), which has a low daily limit. A free account gives you your own key with 250 requests a day, plus request logs and your own collections.\",\n" +
                        "        \"cta\": {\n" +
                        "            \"label\": \"Get a free key\",\n" +
                        "            \"url\": \"https://app.reqres.in/?utm_source=reqres_api&utm_medium=json&utm_campaign=demo_meta_key\"\n" +
                        "        },\n" +
                        "        \"context\": \"keyless_success\"\n" +
                        "    }\n" +
                        "}")
                .build();
    }
}
