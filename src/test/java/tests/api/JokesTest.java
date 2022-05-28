package tests.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import objects.api.Joke;
import objects.api.JokesResponseData;
import objects.api.MainCharacter;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.JokesParser;
import utils.JokesResponseDataParser;
import utils.MainCharacterParser;


import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class JokesTest {

    JokesResponseData jokesResponseData = JokesResponseDataParser.parseData();
    Joke joke = JokesParser.parseData();
    MainCharacter mainCharacter = MainCharacterParser.parseData();

    public JokesTest() throws IOException {
    }

    private static final Logger LOGGER =
            Logger.getLogger(JokesTest.class.getName());

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
    public void fetchRandomJokeTest() {
        RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get("/random")
                .then()
                .assertThat()
                .log()
                .everything()
                .statusCode(200)
                .body("value", notNullValue());
    }

    @Test
    public void changeTheNameOfTheMainCharacterTest() {
        requestSpecification
                .formParam("firstName", mainCharacter.getFirstName())
                .formParam("lastName", mainCharacter.getLastName());
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("value.joke", containsStringIgnoringCase(mainCharacter.getLastName()))
                .extract().body().asString().contains(mainCharacter.getFirstName());
    }

    @Test
    public void fetchMultipleRandomJokesTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/random/3")
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .extract().response().body().prettyPrint();
    }

    @Test
    public void fetchSpecificJokeTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/123")
                .then()
                .assertThat().body("value.joke", equalTo(joke.getJoke()))
                .assertThat().statusCode(200);
    }

    @Test
    public void fetchTheNumberOfJokesTest() {
        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/count")
                .then()
                .assertThat().body("value", equalTo(jokesResponseData.getValue()));
    }

    @After
    public void finish() {
        LOGGER.info("Tests finished.");
    }
}
