package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.ArrayList;
import java.util.List;


public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchTextbox (String textboxName, String value) {
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, textboxName);
        sendKeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, value, textboxName);
    }
    public void pressKeyToKeyboard(Keys keyName) {
        pressKeyToKeyboard(driver, keyName);
    }

    public void clickToPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageNumberActive (String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }
    public boolean isRowValueDisplayed (String femaleNumber, String country, String maleNumber, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUE, femaleNumber, country, maleNumber, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, femaleNumber, country, maleNumber, total);
    }
    public void clickToActionButton (String country, String action) {
        waitForElementClickable(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, country, action);
        clickToElement(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, country, action);
    }

    public List<String> getAllPageValueByColumnName(String columnName) {
        List<String> allValues = new ArrayList<String>();
        List<WebElement> allPageLinks = getListWebElements(driver, HomePageUI.ALL_PAGE_LINK);
        for (WebElement pageLink : allPageLinks) {
            pageLink.click();
            int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
            List<WebElement> allRowValues = getListWebElements(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
            for (WebElement rowValue : allRowValues) {
                allValues.add(rowValue.getText());
            }

        }
        for (String value: allValues) {
            System.out.println(value);
        }
        //Sort by ASC, DSC de so sanh voi DB, API
        return allValues;

    }

    public void inputToTxtByNameAndRow(String columnName, String row, String value) {
        int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW, row, String.valueOf(columnIndex));
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW, value, row, String.valueOf(columnIndex));

    }

    public void selectItemByNameAndRow(String columnName, String row, String value) {
        int columnIndexSelect = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementClickable(driver, HomePageUI.DYNAMIC_SELECT_BOX_BY_COLUMN_AND_ROW, row, String.valueOf(columnIndexSelect));
        selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_SELECT_BOX_BY_COLUMN_AND_ROW, value, row, String.valueOf(columnIndexSelect));

    }

    public void clickToCheckBoxByNameAndRow(String columnName, String row) {
        int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(driver, HomePageUI.DYNAMIC_CHECK_BOX_BY_COLUMN_AND_ROW, row, String.valueOf(columnIndex));
        checkToElement(driver, HomePageUI.DYNAMIC_CHECK_BOX_BY_COLUMN_AND_ROW, row, String.valueOf(columnIndex));

    }
}
