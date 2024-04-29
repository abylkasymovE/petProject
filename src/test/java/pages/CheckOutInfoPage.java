package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckOutInfoPage {

    public CheckOutInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    public WebElement errorMessage;


}
