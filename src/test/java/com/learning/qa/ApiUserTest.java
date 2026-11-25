package com.learning.qa;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ApiUserTest extends BaseTest{
    @Test
    void shouldGetSingleUser() {
        api.getUser(2)
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    void shouldReturn404ForMissingUser() {
        api.getUser(9999)
                .then()
                .statusCode(404);
    }

    @Test
    void shouldListUsersWithPagination() {
        api.listUsers(2, 3)
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("per_page", equalTo(3))
                .body("data.size()", equalTo(3));
    }

    @Test
    void shouldCreateUser() {
        api.createUser("Morpheus", "leader")
                .then()
                .statusCode(201)            // 201 Created
                .body("name", equalTo("Morpheus"))
                .body("job", equalTo("leader"));
    }

    @Test
    void shouldDeleteUser() {
        api.deleteUser(2)
                .then()
                .log().all()
                .statusCode(204);           // 204 No Content
    }

    @Test
    void shouldUseDefaultMethod() {
        // default-метод из интерфейса — не реализовывали, но работает
        boolean exists = api.isUserExists(2);
        assert exists : "User 2 должен существовать";
    }

    @Test
    void shouldReturnTotalPagesGreaterThanOne() {
        api.listResources()
                .then()
                .log().all()
                .statusCode(200)
                .body("total_pages", greaterThan(1));
    }

    @Test
    void shouldUserIdIS605Fake(){
        fakeApi.createUser("Murka", "kitty")
                .then()
                .statusCode(200)
                .body("id", equalTo("605"));
    }
}
