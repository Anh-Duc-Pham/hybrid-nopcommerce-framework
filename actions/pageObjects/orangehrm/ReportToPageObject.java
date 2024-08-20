package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ReportToPageObject extends BasePage {
    private WebDriver driver;

    public ReportToPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
