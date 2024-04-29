package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.Config;
import utilities.Driver;

public class TestClass {
    SauceLogin sauceLogin = new SauceLogin();
    ProductPage productPage = new ProductPage();

    CartPage cartPage = new CartPage();
    CheckOutInfoPage checkOutInfoPage = new CheckOutInfoPage();

    CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();

    Faker faker = new Faker();






    @Test
    public void Navigate(){
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
        Assertions.assertEquals(Config.getProperty("sauceDemo"),Driver.getDriver().getCurrentUrl());

        sauceLogin.login.sendKeys(Config.getProperty("sauceUser"));
        sauceLogin.password.sendKeys(Config.getProperty("saucePassword"));
        sauceLogin.loginButton.click();

        Assertions.assertEquals(Config.getProperty("productPage"), Driver.getDriver().getCurrentUrl());
        productPage.addToCart.click();
        productPage.cartButton.click();

        //verify 1 is appears

        Assertions.assertEquals(Config.getProperty("cartPage"), Driver.getDriver().getCurrentUrl());
        cartPage.checkOutButton.click();

        // verify item is displayed in cart

        Assertions.assertEquals(Config.getProperty("checkOutInfoPage"), Driver.getDriver().getCurrentUrl());
        checkOutInfoPage.continueButton.click();

        // verify remove button displayed
//        Assertions.assertTrue("Remove", cartPage.removeButton.getText());

        Assertions.assertTrue(checkOutInfoPage.errorMessage.isDisplayed());
        
        checkOutInfoPage.firstName.sendKeys(faker.name().firstName());
        checkOutInfoPage.lastName.sendKeys(faker.name().lastName());
        checkOutInfoPage.zipCode.sendKeys(faker.address().zipCode());
        checkOutInfoPage.continueButton.click();

        Assertions.assertEquals(Config.getProperty("checkOutOverview"), Driver.getDriver().getCurrentUrl());
        checkOutOverviewPage.finishButton.click();

        Assertions.assertEquals(Config.getProperty("complete"), Driver.getDriver().getCurrentUrl());
        Assertions.assertTrue(checkOutOverviewPage.thankYouText.isDisplayed());

    }

//    @Test
//    public void negativeTest(){
//
//    }




}
