package com.learning.qa;

import com.learning.qa.api.ApiClient;
import com.learning.qa.api.FakeApiClient;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected ApiClient api;   // тип интерфейса!
    protected FakeApiClient fakeApi = new FakeApiClient();

    @BeforeEach
    void setUp() {
        api = ApiClient.reqres();   // через фабрику
    }
}
