package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;


public class WebDriverFactory {

    private final static Logger logger = Logger.getLogger(WebDriverFactory.class);

    private final static File rootDriversDir = new File("src/main/resources/drivers");

    public enum BrowserName {
        CHROME,
        FIREFOX,
        EDGE,
        PERFCHROME,
        PERFFOX
    }

    public static WebDriver getDriver(BrowserName name) {
        WebDriver driver = null;
        if (name == BrowserName.CHROME) {
            driver = getChromeDriver();
        } else if (name == BrowserName.FIREFOX) {
            driver = getFirefoxDriver();
        } else if (name == BrowserName.EDGE) {
            driver = getEdgeDriver();
        } else if (name == BrowserName.PERFCHROME) {
            driver = getPerfChromeDriver();
        } else if (name == BrowserName.PERFFOX) {
            driver = getPerfFfoxDriver();
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
        } else {
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
        logger.debug("Get chrome driver...");
        File driversDir = getDriversPath();
        File chromeFile = new File(driversDir, "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFile.getPath());
        return new ChromeDriver();
    }

    private static WebDriver getEdgeDriver() {
        logger.debug("Get edge driver...");
        File driversDir = getDriversPath();
        File edgeFile = new File(driversDir, "msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", edgeFile.getPath());
        return new EdgeDriver();
    }

    private static WebDriver getPerfChromeDriver() {
        logger.debug("Get chrome driver with performance...");
        File driversDir = getDriversPath();
        File chromeFile = new File(driversDir, "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFile.getPath());
        return new PerfTrackerChrome();
    }

    private static WebDriver getPerfFfoxDriver() {
        logger.debug("Get firefox driver with performance...");
        File driversDir = getDriversPath();
        File geckoFile = new File(driversDir, "geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", geckoFile.getPath());
        return new PerfTrackerFfox();
    }
}

class PerfTrackerChrome extends ChromeDriver {
    @Override
    public void get(String url) {
        long startTime = System.nanoTime();
        super.get(url);
        long duration = (System.nanoTime() - startTime) / 1000000;
        System.out.println(String.format("[GET] %s: %s ms", url, String.valueOf(duration)));
    }
}

class PerfTrackerFfox extends FirefoxDriver {
    @Override
    public void get(String url) {
        long startTime = System.nanoTime();
        super.get(url);
        long duration = (System.nanoTime() - startTime) / 1000000;
        System.out.println(String.format("[GET] %s: %s ms", url, String.valueOf(duration)));
    }
}
