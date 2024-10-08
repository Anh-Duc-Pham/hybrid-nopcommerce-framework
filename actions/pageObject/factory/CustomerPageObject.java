package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObject extends BasePageFactory {
    private WebDriver driver;
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(css = "input#Email")
    private WebElement emailAddressTextbox;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(firstNameTextbox, "value");

    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(lastNameTextbox, "value" );
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, emailAddressTextbox);
        return getElementAttribute(emailAddressTextbox, "value" );
    }
}
