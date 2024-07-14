package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends MyAccountSideBar {
    WebDriver driver;

    public OrdersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
