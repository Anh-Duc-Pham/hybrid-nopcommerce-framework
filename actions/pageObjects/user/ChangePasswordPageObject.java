package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends MyAccountSideBar {
    WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
