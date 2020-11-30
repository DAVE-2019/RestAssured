import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusValidation {

    @Test
    public void getRatesStatus(){

        given().when().get("https://ratesapi.io/documentation/").then().statusCode(200);

    }

    @Test
    public void getResponse(){


    }
}
