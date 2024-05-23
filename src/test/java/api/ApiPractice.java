package api;

import com.github.javafaker.Faker;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utilities.CashWiseAuthorization;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApiPractice {

    @Test
    public void TestEmail() {
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "api/myaccount/sellers/";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        String email = response.jsonPath().getString("responses[0].email");
        String email2 = response.jsonPath().getString("responses[1].email");
        String email3 = response.jsonPath().getString("responses[2].email");

        int status = response.statusCode();
        Assert.assertEquals(200, status);
        Assert.assertTrue(email.endsWith("@gmail.com"));
        Assert.assertTrue(email2.endsWith("@gmail.com"));

    }

    @Test
    public void improvedAllSellers() {
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "api/myaccount/sellers/";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        int size = response.jsonPath().getList("responses").size();
        int status = response.statusCode();
        Assert.assertEquals(200, status);
        for (int i = 0; i < size; i++) {
            String email = response.jsonPath().getString("responses[" + i + "].email");
            Assert.assertFalse(email.isEmpty());
            Assert.assertTrue(email.endsWith(".com"));
            System.out.println(email);
        }
    }

    @Test
    public void getAllBankAccounts() {
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "api/myaccount/bankaccount/";


        Response response = RestAssured.given().auth().oauth2(token).get(url);
        int status = response.statusCode();
        Assert.assertEquals(200, status);
        response.prettyPrint();
//        int size = response.jsonPath().getList("JSON").size();

    }

    @Test
    public void createBankAccount() {
        Faker faker = new Faker();
        RequestBody requestBody = new RequestBody();
        requestBody.setBank_account_name("Wells Fargo");
        requestBody.setDescription("bank");
        requestBody.setType_of_pay("CASH");
        requestBody.setBalance(faker.number().numberBetween(10000, 100000000));
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "api/myaccount/bankaccount/";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).auth().oauth2(token).post(url);
        int status = response.statusCode();
        Assert.assertEquals(201, status);

        response.prettyPrint();
    }

    @Test
    public void getBankAccount() {
        String token = CashWiseAuthorization.getToken();
        String url = Config.getProperty("cashWiseApiUrl") + "api/myaccount/bankaccount/";


        Response response = RestAssured.given().auth().oauth2(token).get(url);
        int status = response.statusCode();
        Assert.assertEquals(200, status);
        System.out.println(status);

        int size = response.jsonPath().getList("JSON").size();

        String expBank = "Wells Fargo";
        boolean isPresent = false;

        for (int i = 0; i < size; i++) {
            String bankAc = response.jsonPath().getString("bank_account_name[" + i + "]");
            System.out.println(bankAc);
            if (bankAc.equalsIgnoreCase(expBank)) {
                isPresent = true;
            }
        }
        Assert.assertTrue(isPresent);
    }}

