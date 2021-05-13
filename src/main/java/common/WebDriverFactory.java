package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


public class WebDriverFactory {

    private final static Logger logger = Logger.getLogger(WebDriverFactory.class);

    private final static File rootDriversDir = new File("java_selenium/src/main/resources/drivers");

    public enum BrowserName {
        CHROME,
        FIREFOX
    }

    public static WebDriver getDriver(BrowserName name) {
        WebDriver driver = null;
        if (name == BrowserName.CHROME) {
            driver = getChromeDriver();
        } else if (name == BrowserName.FIREFOX) {
            driver = getFirefoxDriver();
        } else {
            throw new InvalidArgumentException("Invalid browser option");
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static File getDriversPath() {
        String os = System.getProperty("os.name");
        File osDriversDir = null;
        logger.debug("Operating system: " + os);
        logger.debug("Drivers root directory: " + rootDriversDir.toString());
        if (os.toLowerCase().contains("windows")) {
            osDriversDir = new File(rootDriversDir, "windows");
        } else if (os.toLowerCase().contains("mac")) {
            osDriversDir = new File(rootDriversDir, "mac");
        } else{
            throw new InvalidArgumentException("Invalid operating system: " + os);
        }
        logger.debug("OS drivers directory: " + osDriversDir.toString());
        return osDriversDir;
    }

    private static WebDriver getFirefoxDriver() {
        logger.debug("Get firefox driver...");
        File driversDir = getDriversPath();
        File geckoFile = new File(driversDir, "geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", geckoFile.getPath());
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        logger.debug("Get chrome driver..");
        File driversDir = getDriversPath();
        File chromeFile = new File(driversDir, "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFile.getPath());
        return new ChromeDriver();
    }
}
