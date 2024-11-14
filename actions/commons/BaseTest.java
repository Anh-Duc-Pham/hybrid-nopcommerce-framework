package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

public class BaseTest {
    protected final Logger log;
    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }



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
            case FIREFOX_HEADLESS:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("-headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE_HEADLESS:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("-headless");
                edgeOptions.addArguments("window-size=1920x1080");
                driver = new EdgeDriver(edgeOptions);
                break;


            default:
                throw new RuntimeException("Browser name is not valid");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(GlobalConstants.DEV_USER_URL);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserEnvironment(String browserName, String serverName) {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(getServerByName(serverName));
        return driver;
    }

    private String getServerByName(String serverName) {
        ServerList server = ServerList.valueOf(serverName.toUpperCase());

        switch (server) {
            case DEV:
                serverName = "https://demo.nopcommerce.com/";
                break;
            case TEST:
                serverName = "https://test.nopcommerce.com/";
                break;
            case STAGING:
                serverName = "https://staging.nopcommerce.com/";
                break;
            default:
                throw new IllegalArgumentException("Unexpected value" + serverName);
        }
        return serverName;
    }

    protected String getRandomEmail() {
        Random emailNumber = new Random();
        return "edenhazard" + emailNumber.nextInt(9999) + "@gmail.com";
    }

    protected String getRandomEmail(String prefix) {
        Random emailNumber = new Random();
        return prefix + emailNumber.nextInt(9999) + "@gmail.com";
    }
    protected WebDriver getBrowserDriver(String browserName, String url, String osName, String ipAddress, String portNumber) {
        Capabilities capability = null;

        Platform platform;
        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }



    protected void closeWindow() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("--------------------PASSED--------------------");
        } catch (Throwable e) {
            log.info("--------------------FAILED--------------------");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("--------------------PASSED--------------------");
        } catch (Throwable e) {
            log.info("--------------------FAILED--------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("--------------------PASSED--------------------");
        } catch (Throwable e) {
            log.info("--------------------FAILED--------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("allure-json/environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected WebDriver getBrowserDriverSaucelab(String url, String osName, String browserName, String browserVersion) {
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(osName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(osName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(osName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(osName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put("username", GlobalConstants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "automation-fc-build");
        sauceOptions.put("name", "Run on " + osName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

}
