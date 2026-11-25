package com.learning.qa.api;

import io.restassured.response.Response;

public interface ApiClient {

    // Получить пользователя по ID
    Response getUser(int id);

    // Получить список пользователей на странице
    Response listUsers(int page, int perPage);

    // Создать пользователя
    Response createUser(String name, String job);

    // Удалить пользователя
    Response deleteUser(int id);

    // Список ресурсов /unknown
    Response listResources();

    // Default-метод — проверка существования пользователя
    default boolean isUserExists(int id) {
        return getUser(id).getStatusCode() == 200;
    }

    // Static-фабрика — создаёт клиент для reqres.in
    static ApiClient reqres() {
        return new ReqresApiClient("https://reqres.in/api");
    }
}
