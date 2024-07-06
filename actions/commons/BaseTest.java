package commons;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");

        }
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1280, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://demo.nopcommerce.com/");
        return driver;
    }

    protected String getRandomEmail() {
        Random emailNumber = new Random();
        return "edenhazard" + emailNumber.nextInt(9999) + "@gmail.com";
    }
    protected void closeWindow() {
        if (driver == null) {
            System.out.println("Window is already closed");
        }else {
            driver.close();
        }
    }
}
