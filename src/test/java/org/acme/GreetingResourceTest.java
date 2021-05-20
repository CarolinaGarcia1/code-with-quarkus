package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/pets?pageNum=0&pageSize=2")
          .then()
             .statusCode(200)
                .body(
                        "$.size()", is(2),
                        "name", containsInAnyOrder("Leo", "Basil")
                );
    }

}