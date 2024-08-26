package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPageObject extends BaseActions {
    WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
