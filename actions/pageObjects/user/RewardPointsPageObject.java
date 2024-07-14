package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class RewardPointsPageObject extends MyAccountSideBar {
    WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
