package utilities;

import api.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CashWiseAuthorization {
    public static String getToken(){
        String url = Config.getProperty("cashWiseApiUrl") + "/api/myaccount/auth/login";

        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("emir_77777@mail.ru");
        requestBody.setPassword("emin757575");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);

        return response.jsonPath().getString("jwt_token");
    }
}
