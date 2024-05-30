package api;

import lombok.Data;

@Data
public class RequestBody {
    private String email;
    private String password;
    private String type_of_pay;
    private String bank_account_name;
    private String description;
    private int balance;
    private String category_title;
    private String category_description;
    private boolean flag;

    private String company_name;
    private String seller_name;
    private String phone_number;
    private String address;



    /*
    {
  "company_name": "string",
  "seller_name": "string",
  "email": "string",
  "phone_number": "string",
  "address": "string"
}
     */



}
