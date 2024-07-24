package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class AddressPageObject extends MyAccountSideBar {
    WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
