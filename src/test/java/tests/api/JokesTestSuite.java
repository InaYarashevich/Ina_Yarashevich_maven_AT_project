package tests.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import objects.api.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.DataParser;


import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class JokesTestSuite {

    Joke jokeData = DataParser.parseJokesData();
    MainCharacter mainCharacter = DataParser.parseMainCharacterData();

    public JokesTestSuite() throws IOException {
    }

    private static final Logger LOGGER =
            Logger.getLogger(JokesTestSuite.class.getName());

    RequestSpecification requestSpecification = RestAssured.given().spec(new RequestSpecBuilder()
            .setBaseUri("http://api.icndb.com")
            .setBasePath("/jokes")
            .setAccept(ContentType.ANY)
            .setContentType(ContentType.JSON)
            .build());

    @Before
    public void setup() {
        LOGGER.info("Starting the tests");
    }

    @Test
    public void fetchRandomJokeStatusCodeTest() {
        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get("/random")
                .then()
                .statusCode(200);
    }

    @Test
    public void fetchRandomJokeResponseTypeTest() {
        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get("/random")
                .then()
                .extract()
                .body()
                .as(JokeResponseData.class)
                .getType()
                .equals("success");
    }

    @Test
    public void fetchRandomJokeResponseValueTest() {
        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get("/random")
                .then()
                .extract()
                .body()
                .as(JokeResponseData.class)
                .getJoke()
                .getId(); //NullPointerException
    }

    @Test
    public void changeTheNameOfTheMainCharacterStatusCodeTest() {
        requestSpecification
                .formParam("firstName", mainCharacter.getFirstName())
                .formParam("lastName", mainCharacter.getLastName());
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void changeTheNameOfTheMainCharacterResponseTest() {
        requestSpecification
                .formParam("firstName", mainCharacter.getFirstName())
                .formParam("lastName", mainCharacter.getLastName());
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract()
                .response()
                .as(JokeResponseData.class)
                .getJoke()
                .equals(Joke.class); // NullPointerException
    }

    @Test
    public void changeTheNameOfTheMainCharacterTextTest() {
        requestSpecification
                .formParam("firstName", mainCharacter.getFirstName())
                .formParam("lastName", mainCharacter.getLastName());
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract()
                .body()
                .jsonPath()
                .get("value.joke")
                .toString()
                .contains(mainCharacter.getFirstName());
    }

    @Test
    public void fetchMultipleRandomJokesStatusCodeTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/random/3")
                .then()
                .statusCode(200);
    }

    @Test
    public void fetchMultipleRandomJokesResponseBodyTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/random/3")
                .then()
                .extract()
                .body()
                .as(JokesListData.class);
    }

    @Test
    public void fetchMultipleRandomJokesResponseValueTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/random/3")
                .then()
                .extract()
                .body()
                .as(JokesListData.class)
                .getValue()
                .contains(Joke.class);
    }


    @Test
    public void fetchSpecificJokeStatusCodeTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/123")
                .then()
                .statusCode(200);
    }

    @Test
    public void fetchSpecificJokeResponseTypeTest() throws NoSuchFieldException {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/123")
                .then()
                .extract()
                .body()
                .as(JokeResponseData.class)
                .getType()
                .equals("success");
    }

    @Test
    public void fetchSpecificJokeTextTest() throws NoSuchFieldException {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/123")
                .then()
                .extract()
                .body()
                .jsonPath()
                .get("value.joke") // так можно?
                .equals(jokeData.getJoke());
    }

    @Test
    public void fetchTheNumberOfJokesStatusCodeTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/count")
                .then()
                .statusCode(200);
    }


    @Test
    public void fetchTheNumberOfJokesTypeTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/count")
                .then()
                .log()
                .everything()
                .extract()
                .body()
                .as(JokesCountData.class)
                .getType()
                .equals("success");
    }

    @Test
    public void fetchTheNumberOfJokesQuantityTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/count")
                .then()
                .log()
                .everything()
                .extract()
                .body()
                .as(JokesCountData.class)
                .getValue(); // как сравнить кол-во шуток пришедших в респонзе с ожидаемым рез-том (574)?
    }

    @After
    public void finish() {
        LOGGER.info("Tests finished.");
    }
}
