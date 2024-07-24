package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class BackInStockSubcriptionsPageObject extends MyAccountSideBar {
    WebDriver driver;

    public BackInStockSubcriptionsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
