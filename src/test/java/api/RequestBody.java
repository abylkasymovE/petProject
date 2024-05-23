package api;

public class RequestBody {
    private String email;
    private String password;
    private String type_of_pay;
    private String bank_account_name;
    private String description;
    private int balance;

    public String getType_of_pay() {
        return type_of_pay;
    }

    public void setType_of_pay(String type_of_pay) {
        this.type_of_pay = type_of_pay;
    }

    public String getBank_account_name() {
        return bank_account_name;
    }

    public void setBank_account_name(String bank_account_name) {
        this.bank_account_name = bank_account_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
