package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToTextboxByName(String firstName, String eden) {
    }

    public String getEmployeeID() {
        return "";
    }

    public void clickToSaveButton() {
    }

    public boolean isSuccessMsgDisplayed(String successfullySaved) {

        return false;
    }
}
