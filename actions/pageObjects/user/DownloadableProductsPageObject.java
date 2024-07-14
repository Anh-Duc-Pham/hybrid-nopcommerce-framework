package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class DownloadableProductsPageObject extends MyAccountSideBar {
    WebDriver driver;

    public DownloadableProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
