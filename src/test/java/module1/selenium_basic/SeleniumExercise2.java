package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.StringUtils;

public class SeleniumExercise2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.FIREFOX);

        String googleURL = "https://www.google.com";
        driver.get(googleURL);

        String tittle = driver.getTitle();
        System.out.println("page title: " + tittle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("current URL: " + currentURL);

        String sourceCode = driver.getPageSource();
        System.out.println("source code: " + sourceCode);

        driver.close();

        String functionn = "function";
        String scriptt = "script";
        String classs = "class";
        String idd = "id";

        int countFunction = StringUtils.countMatches(sourceCode, functionn);
        int countscript = StringUtils.countMatches(sourceCode, scriptt);
        int countclass = StringUtils.countMatches(sourceCode, classs);
        int countid = StringUtils.countMatches(sourceCode, idd);

        System.out.println("Frequency of these words in the source code:"
        + "\nfunction: " + countFunction
        + "\nscript: " + countscript
        + "\nclass: " + countclass
        + "\nid: " + countid);
    }

}

