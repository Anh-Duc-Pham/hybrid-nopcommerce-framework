package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {
    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public Set<Cookie> getBrowserCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setBrowserCookie(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    //Web Element


    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendKeyToElement( WebElement element, String valueToSend) {
        element.clear();
        element.sendKeys(valueToSend);
    }

    public void selectItemInDefaultDropdown(WebElement element, String itemValue) {
        new Select(element).selectByVisibleText(itemValue);
    }

    public String getFirstItemTextInDefaultDropdown(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple( WebElement element) {
        return new Select(element).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, WebElement parentElement, By childElementLocator, String expectedItem) {
        parentElement.click();
        sleepInSecond(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElementLocator));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getElementText( WebElement element) {
        return element.getText();
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public String getElementCssValue (WebElement element, String cssPropertyName) {
        return element.getCssValue(cssPropertyName);
    }
    public String convertRGBAToHexaColor (WebElement element) {
        return  Color.fromString(getElementCssValue(element, "background-color")).asHex();
    }

    public int getListElementSize (List<WebElement> elements) {
        return elements.size();
    }

    public void checkToElement (WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }
    public void uncheckToElement (WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void switchToIframe(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
    public void doubleClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }
    public void rightClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }
    public void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
        new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
    }
    public void sendKeyBoardToElement(WebDriver driver, WebElement element, Keys key) {
        new Actions(driver).sendKeys(element, key).perform();
    }

    public Object executeForBrowser(WebDriver driver,String javaScript) {

        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver,String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }
    public void hightlightElement(WebDriver driver, WebElement element) {
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        sleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElementOnDownByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", element);
    }

    public void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    public void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public String getAttributeInDOMByJS(WebDriver driver, WebElement element, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", element);
    }

    public String getWebElementValidationMessage(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
    }

    public boolean isImageLoaded(WebDriver driver, WebElement element) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                element);
    }
    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForListElementsVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForElementInvisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitForListElementsInvisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
