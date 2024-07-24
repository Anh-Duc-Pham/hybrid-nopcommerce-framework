package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class MyProductReviewPageObject extends MyAccountSideBar {
    WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
