package com.minimal.restapi.integration;

import com.minimal.restapi.model.Film;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MinimalControllerApiTest {

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