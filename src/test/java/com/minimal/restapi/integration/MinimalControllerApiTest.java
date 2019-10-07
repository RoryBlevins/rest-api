package com.minimal.restapi.integration;

import com.minimal.restapi.model.Film;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class MinimalControllerApiTest {

    @LocalServerPort
    private int port;

    @Test
    public void getRequestReturns() {
        get("/status").then().assertThat().body(equalTo("up"));
    }

    @Test
    public void postRequestConcatenatesInput() {
        given().body("James").post("/hello").then().assertThat().body(equalTo("Hello James"));
    }

    @Test
    public void postToFilmsReturnsFilm() {
        given()
                .body(new Film("Jaws", "Steven Spielberg"))
                .contentType(ContentType.JSON)
                .when()
                .post("/films")
                .then()
                .assertThat().body("name", equalTo("Jaws"));
    }

}