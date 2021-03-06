package classwork.day19.runners;


import classwork.day21.Search;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredRunner {

    public static void main(String[] args) {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://178.124.206.46:8001/app/ws/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured
                .given()
                .spec(requestSpecification)
                .body(new Search("a", true))
                .when()
                .post()
                .then()
                .extract().body().asString();
    }
}
