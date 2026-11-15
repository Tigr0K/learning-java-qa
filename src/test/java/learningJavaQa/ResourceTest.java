package learningJavaQa;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ResourceTest extends BaseTest{
@Test
    public void uncnownTest(){
    given()
            .when()
            .get("/unknown")
            .then()
            .statusCode(200);
}
}
