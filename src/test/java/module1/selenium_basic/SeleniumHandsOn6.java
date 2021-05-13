package module1.selenium_basic;

import common.WebDriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumHandsOn6 {
    public static void main(String[] args) {

        final String wikipediaURL = "https://www.wikipedia.org/";
        String searchTopic = "Selenium";

        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);

        driver.get(wikipediaURL);

        WebElement searchTextBox = driver.findElement(By.id("searchInput"));
        searchTextBox.sendKeys(searchTopic);

        WebElement searchButton = driver.findElement(By.xpath("//i[contains(text(),'Search')]"));
        searchButton.click();


        countMatches(driver, searchTopic);


        List<String> first5Links = new ArrayList<>();
        int countValidLinks = 0;

        //int countTopicInA = 0;
        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        for (WebElement tmp : aElements) {

            String aLink = tmp.getAttribute("href");
            //System.out.println(aLink);

            if (aLink != null) {
                int count = StringUtils.countMatches(aLink.toLowerCase(), searchTopic.toLowerCase());
                //System.out.println(count);

                //countTopicInA = countTopicInA + count;

                if (count > 0 && countValidLinks < 5 && !aLink.contains("#") && !aLink.contains("File:") && !aLink.contains("Category:") && !aLink.contains("Template:Infobox") && !aLink.contains("&action=edit")) {
                    first5Links.add(aLink);
                    countValidLinks++;
                }
            }
            //System.out.println(countTopicInA);
        }


        for (String tmp : first5Links) {
            //System.out.println("Here to test stale element: " + tmp);
            driver.get(tmp);
            countMatches(driver, searchTopic);
        }


        driver.close();

    }

    public static void countMatches(WebDriver driver, String searchTopic) {
        int countTopicInP = 0;
        List<WebElement> pElements = driver.findElements(By.tagName("p"));
        for (WebElement tmp : pElements) {

            String pText = tmp.getText();
            //System.out.println(pText);

            int count = StringUtils.countMatches(pText.toLowerCase(), searchTopic.toLowerCase());
            //System.out.println(count);

            countTopicInP = countTopicInP + count;
            //System.out.println(countTopicInP);
        }

        System.out.println("\nCurrent URL: \"" + driver.getCurrentUrl() + "\""
                + "\nSearch topic: " + searchTopic
                + "\nNumber of matches in paragraphs (case-insensitive): " + countTopicInP);
    }
}
