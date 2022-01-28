package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class NetworkSpecification {

    private final static String BASE_URL = "http://test-api.d6.dev.devcaz.com";

    public static RequestSpecification requestSpec() {
        return given()
                .spec(new RequestSpecBuilder().build())
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .log()
                .all()
                .baseUri(BASE_URL)
                .when();
    }
}
