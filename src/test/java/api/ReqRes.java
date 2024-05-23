package api;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v121.fetch.model.AuthChallengeResponse;

public class ReqRes {
    @Test
    public void FirstTest(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        String first_name = response.jsonPath().getString("data.first_name");
        System.out.println(first_name);
        Assert.assertEquals(first_name, "Janet");
        int status = response.statusCode();
        Assert.assertEquals(status, 200);

    }

    @Test
    public void emailCheck(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        String email = response.jsonPath().getString("data.email");
        System.out.println(email);
        Assert.assertTrue(email.endsWith("@reqres.in"));
        int status = response.statusCode();
        Assert.assertEquals(status, 200);

    }

    @Test
    public void text(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        String text1 = response.jsonPath().getString("support.text");
        System.out.println(text1);
        Assert.assertEquals(text1, "To keep ReqRes free, contributions towards server costs are appreciated!");
    }

    @Test
    public void Post(){
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("emir_77777@mail.ru");
        requestBody.setPassword("emin757575");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/auth/login");
        response.statusCode();
        response.prettyPrint();


    }


}


