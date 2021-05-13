package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


public class WebDriverFactory {

    private final static Logger LOGGER = Logger.getLogger(WebDriverFactory.class);

    private final static File ROOT_DRIVERS_DIR = new File("src/main/resources/drivers");

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
        LOGGER.debug("Operating system: " + os);
        LOGGER.debug("Drivers root directory: " + ROOT_DRIVERS_DIR.toString());
        if (os.toLowerCase().contains("windows")) {
            osDriversDir = new File(ROOT_DRIVERS_DIR, "windows");
        } else if (os.toLowerCase().contains("mac")) {
            osDriversDir = new File(ROOT_DRIVERS_DIR, "mac");
        } else{
            throw new InvalidArgumentException("Invalid operating system: " + os);
        }
        LOGGER.debug("OS drivers directory: " + osDriversDir.toString());
        return osDriversDir;
    }

    private static WebDriver getFirefoxDriver() {
        LOGGER.debug("Get firefox driver...");
        File driversDir = getDriversPath();
        File geckoFile = new File(driversDir, "geckodriver.exe");
        LOGGER.debug("Chrome driver path: "+ geckoFile.getPath());
        System.setProperty("webdriver.gecko.driver", geckoFile.getPath());
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        LOGGER.debug("Get chrome driver..");
        File driversDir = getDriversPath();
        File chromeFile = new File(driversDir, "chromedriver.exe");
        LOGGER.debug("Chrome driver path: "+ chromeFile.getPath());
        System.setProperty("webdriver.chrome.driver", chromeFile.getPath());
//        //Add options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments();

        return new ChromeDriver();
    }
}
