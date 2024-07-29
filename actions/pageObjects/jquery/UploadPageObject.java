package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.ArrayList;
import java.util.List;


public class UploadPageObject extends BasePage {
    private WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
