package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.UpLoadPageUI;

import java.util.List;


public class UploadPageObject extends BasePage {
    private WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoaded(String fileName) {
        waitForElementVisible(driver, UpLoadPageUI.FILE_LOADED_SUCCESS, fileName);
        return isElementDisplayed(driver, UpLoadPageUI.FILE_LOADED_SUCCESS, fileName);
    }

    public void clickToStartUploadButtonOnEachFile() {
        List<WebElement> startButtons = getListWebElements(driver, UpLoadPageUI.START_UPLOAD_BUTTONS);
        for (WebElement button: startButtons) {
            waitForElementClickable(driver, button);
            clickToElement(driver, button);
        }
    }

    public boolean isUploadFileAppeer(String fileName) {
        waitForElementVisible(driver, UpLoadPageUI.UPLOAD_FILE_INFO, fileName);
        return isElementDisplayed(driver, UpLoadPageUI.UPLOAD_FILE_INFO, fileName);
    }



}


