package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class TaxExemptionsPageObject extends BasePage {
    WebDriver driver;

    public TaxExemptionsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
