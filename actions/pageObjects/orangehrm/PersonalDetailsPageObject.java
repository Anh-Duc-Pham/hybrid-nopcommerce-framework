package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPageObject extends BasePage {
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
