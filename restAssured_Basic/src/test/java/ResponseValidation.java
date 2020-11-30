import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseValidation {

    Response response = (Response) RestAssured.given().when().get("https://jsonplaceholder.typicode.com/users/1").getBody();

    @Test
    public void ResponseStatus(){
        JsonPath jsonPath = response.jsonPath();
        String username = jsonPath.get("username");
        Assert.assertTrue(username.equalsIgnoreCase("Bret"));
    }

    @Test
    public void PostRequestStatus(){
        RestAssured.baseURI = "http://localhost:8080/profiles";
        RequestSpecification request = RestAssured.given();

        JSONObject profileNew = new JSONObject();
        profileNew.put("name","Sayandev");
        profileNew.put("email","s.roy@gmail.com");

        request.header("Content-Type","application/json");
        request.body(profileNew.toString());

        Response response1= request.post("/new");

        int statusCode = response1.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

}
