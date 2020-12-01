import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAParameterization {

    @Test
    public void useOfPathParam(){
        given().pathParam("num","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/users/{num}")
                .then()
                .statusCode(200);
    }

    @Test
    public void useOfQueryParam(){
        given().queryParam("postId",1)
                .when().get("https://jsonplaceholder.typicode.com/comments")
                .then().statusCode(200);
    }


}
