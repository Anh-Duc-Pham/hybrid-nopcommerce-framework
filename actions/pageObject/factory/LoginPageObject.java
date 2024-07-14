package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
