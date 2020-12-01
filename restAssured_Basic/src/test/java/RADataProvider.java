import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

public class RADataProvider {

    @DataProvider(name="countryDataProvider")
    public Object[] getCountryData(){
        Object[][] countryData = {{"Finland"}, {"India"}, {"United States"}};
        return (countryData);
    }
    @Test(dataProvider="countryDataProvider")
    public void getCountryDetails(String countryName){
        given().
                pathParam("country", countryName).
                when().
                get("http://restcountries.eu/rest/v1/name/{country}").
                then().
                assertThat()
                .body("capital", contains("Helsinki"));

    }
}
