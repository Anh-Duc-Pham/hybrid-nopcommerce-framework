package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPageObject extends BasePage {
    private WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
