package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class TaxExemptionsPageObject extends BaseActions {
    WebDriver driver;

    public TaxExemptionsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
