package tests.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class JokesTest {

    @Before
    public void setup(){
        RestAssured.given().spec(new RequestSpecBuilder()
                .setBaseUri("http://api.icndb.com")
                .setAccept(ContentType.ANY)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build());
    }

    @Test
    public void fetchRandomJoke() {
                when()
                .get("/jokes/random")
                .then()
                .extract().response().body().prettyPrint();
    }

    @Test
    public void changeTheNameOfTheMainCharacter(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.icndb.com/jokes/random?firstName=John&lastName=Doe")
                .setAccept(ContentType.ANY)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().response().body().prettyPrint();
    }

    @Test
    public void fetchMultipleRandomJokes(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.icndb.com/jokes/random/3")
                .setAccept(ContentType.ANY)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().response().body().prettyPrint();
    }

    @Test
    public void fetchSpecificJoke(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.icndb.com/jokes/123")
                .setAccept(ContentType.ANY)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().response().body().prettyPrint();
    }

    @Test
    public void fetchTheNumberOfJokes(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://api.icndb.com/jokes/count")
                .setAccept(ContentType.ANY)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().response().body().prettyPrint();
    }
}
