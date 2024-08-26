package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.DashboardUI;

public class DashboardPageObject extends BaseActions {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EmployeeListPageObject clickToPIMOnMenu() {
        waitForElementClickable(driver, DashboardUI.PIM_MODULE);
        clickToElement(driver, DashboardUI.PIM_MODULE);
        waitForSpinnerInvisible();
        return PageGeneratorManager.getEmployeeListPage(driver);
    }
}
