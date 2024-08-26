package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SalaryPageObject extends BaseActions {
    WebDriver driver;

    public SalaryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
