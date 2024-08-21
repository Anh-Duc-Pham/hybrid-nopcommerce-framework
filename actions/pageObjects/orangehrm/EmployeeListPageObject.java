package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeListPageObject extends BasePage {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeOnMenu() {
        return null;
    }

    public void enterToEmployeeIDTextbox(String employeeID) {
    }

    public void clickToSearchButton() {
    }

    public boolean isValueDisplayedAtColumName(String id, String employeeID) {
    }
}
