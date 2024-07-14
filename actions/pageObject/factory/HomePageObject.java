package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement registerLink;
    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;
    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(myAccountLink);
    }
}
