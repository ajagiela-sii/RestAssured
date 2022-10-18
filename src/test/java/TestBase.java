import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    public static void reqSpec(){
/*        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.openweathermap.org/data/2.5/weather")
                .addParam("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());*/
    }

    @BeforeEach
    public void setUp() {
       // RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
      //  RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static RequestSpecification getRequestSpec() {
        return RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.openweathermap.org/data/2.5/weather")
                .addParam("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .addHeader("name", "Oxford")
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .build()
                .statusCode(200);
    }
}
