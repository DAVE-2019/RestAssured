package scenarios;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RestParsing {

    private String path;
    private Response response;
    public String validRequest = "{\n"+ "\"name\": \"morpheus\",\n" + "\"job\": \"leader\" \n}";

    @Given("the users endpoint exists")
    public void preReq(){
        RestAssured.baseURI="https://reqres.in/api";
        path="/user";

    }

    @When("Send a valid user payload")
    public void createUser(){

        response = given().auth().preemptive().basic("MY_NAME","MY_JOB").
                header("Accept", ContentType.JSON.getAcceptHeader()).contentType(ContentType.JSON)
                .body(validRequest)
                .post(path)
                .then().extract().response();

    }

    @Then("response status code should be {int}")
    public void checkResponseStatusCode(int code){
        Assert.assertEquals(code,response.getStatusCode());
    }

    @And("create user response should be valid")
    public void verifyResponse(){

        String username = response.path("name");
        String job = response.path("job");
        String id = response.path("id");

        Assert.assertEquals("morpheus",username);
        Assert.assertEquals("leader",job);
        Assert.assertNotNull(id);


    }
}
