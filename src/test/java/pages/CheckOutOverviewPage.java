package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckOutOverviewPage {
    public CheckOutOverviewPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = "h2[class='complete-header']")
    public WebElement thankYouText;

}
