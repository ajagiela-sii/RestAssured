import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ApiTests extends TestBase {
    

    @Test
    public void shouldGetCurrentWeatherForOxfordCity() {
        RestAssured.given()
                .spec(TestBase.getRequestSpec())
                .param( "id", "2640729")
        .when()
                .get()
        .then()
                .spec(TestBase.getResponseSpec());
    }

    @Test
    public void shouldGetCurrentWeatherForGdanskCity() {
        String baseUri = "https://api.openweathermap.org/data/2.5";
        float actualId = RestAssured.given()
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param( "id", "3099434")
                .baseUri(baseUri)
                .basePath("/weather")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path("wind.speed");

        System.out.println("Actual id: " + actualId);
        assertThat(actualId).isEqualTo(3.6F);

    }

    @Test
    public void shouldGetCurrentWeatherForGdanskCity1() {
        String baseUri = "https://api.openweathermap.org/data/2.5";
        float actualId = RestAssured.given()
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param( "id", "3099434")
                .baseUri(baseUri)
                .basePath("/weather")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("wind.speed");

        System.out.println("Actual id: " + actualId);
        assertThat(actualId).isEqualTo(3.6F);

    }

    @Test
    public void shouldGetCurrentWeatherForGdanskCity2() {
        String baseUri = "https://api.openweathermap.org/data/2.5";
        RestAssured.given()
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param( "id", "3099434")
                .baseUri(baseUri)
                .basePath("/weather")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("wind.speed", is(3.6F))
                .body("wind.speed", greaterThanOrEqualTo(3.1F))
                .body("name", is("Gdańsk"));
    }

    @Test
    public void shouldGetCurrentWeatherForLondonCity() {
        String baseUri = "https://api.openweathermap.org/data/2.5/weather";
        RestAssured.given()
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param( "id", "2643743")
                .baseUri(baseUri)
                .basePath("")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }



}
