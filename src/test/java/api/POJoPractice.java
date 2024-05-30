package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utilities.CashWiseAuthorization;
import utilities.Config;

public class POJoPractice {
    @Test
    public void createCategory(){
        String url = Config.getProperty("cashWiseApiUrl") + "/api/myaccount/categories";
        String token = CashWiseAuthorization.getToken();
        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("transportation");
        requestBody.setCategory_description("truck company");
        requestBody.setFlag(true);

        Response response = RestAssured.given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int status = response.statusCode();
        Assert.assertEquals(201, status);
    }

    @Test
    public void testCustom() throws JsonProcessingException {
        String url = Config.getProperty("cashWiseApiUrl") + "/api/myaccount/categories";
        String token = CashWiseAuthorization.getToken();
        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("bank");
        requestBody.setCategory_description("BOFA");
        requestBody.setFlag(true);

        Response response = RestAssured.given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int status = response.statusCode();
        Assert.assertEquals(201, status);

        response.prettyPrint();

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        String expectedTitle = customResponse.getCategory_title();
        String expectedCategoryDescription = customResponse.getCategory_description();

        Assert.assertEquals(expectedTitle, "bank");
        Assert.assertEquals(expectedCategoryDescription, "BOFA");

    }
    @Test
    public void createGetSeller() throws JsonProcessingException {
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "/api/myaccount/sellers";

        Faker faker = new Faker();
        RequestBody requestBody = new RequestBody();

        requestBody.setSeller_name("Ilon Mask");
        requestBody.setCompany_name("Tesla");
        requestBody.setEmail(faker.internet().emailAddress());
        requestBody.setPhone_number("2223334444");
        requestBody.setAddress("2250 devon avenue");
        Response response = RestAssured.given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody).post(url);

        int status = response.statusCode();
        Assert.assertEquals(201, status);

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        int id = customResponse.getSeller_id();

        String url1 = Config.getProperty("cashWiseApiUrl") + "/api/myaccount/sellers/"+ id;

        Response response1 = RestAssured.given().auth().oauth2(token).get(url1);

        int status2 = response1.statusCode();
        Assert.assertEquals(200, status2);

        String expectedSellerName = customResponse.getSeller_name();
        Assert.assertEquals("Ilon Mask", expectedSellerName);

        String expectedCompanyName = customResponse.getCompany_name();
        Assert.assertEquals("Tesla", expectedCompanyName);
    }
}
