package step_definition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SauceLogin;
import utilities.Config;
import utilities.Driver;

public class loginDemoSteps {
//    WebDriver driver = Driver.getDriver();
    SauceLogin sauceLogin = new SauceLogin();


    @Given("user is on sauce demo login page")
    public void user_is_on_sauce_demo_login_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
    }

    @When("user provides a valid username")
    public void user_provides_a_valid_username() {
        sauceLogin.login.sendKeys(Config.getProperty("sauceUser"));
    }

    @When("user provides a valid password")
    public void user_provides_a_valid_password() {
        sauceLogin.password.sendKeys(Config.getProperty("saucePassword"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        sauceLogin.loginButton.click();
    }

    @Then("verify user successfully logged in")
    public void verify_user_successfully_logged_in() {
        Assert.assertEquals(Config.getProperty("productPage"), Driver.getDriver().getCurrentUrl());
        Driver.getDriver().close();
        Driver.getDriver().quit();
    }

    @When("user provides a invalid username")
    public void user_provides_a_invalid_username() {
        sauceLogin.login.sendKeys("ssdda");
    }
    @When("user provides a invalid password")
    public void user_provides_a_invalid_password() {
        sauceLogin.password.sendKeys("sdadsahd2");

    }
    @Then("verify user sees an error message")
    public void verify_user_sees_an_error_message() {
        Assert.assertTrue(sauceLogin.errorMessage.isDisplayed());
    }
}
