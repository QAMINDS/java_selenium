package module1.selenium_basic;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandsOn6 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.get("https://www.wikipedia.org/");

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Selenium");
        search.sendKeys(Keys.ENTER);

        List<WebElement> pElements = driver.findElements(By.tagName("p"));
        int C=0;

        for (WebElement tmp : pElements) {

            if (tmp.getText().contains("Selenium")) {
                C ++;
            }
        }

        System.out.println("Current URL: "+driver.getCurrentUrl());
        System.out.println("The search topic Selenium is contained in p elements: "+ C +" times.");

        List<WebElement> aElements = driver.findElements(By.tagName("a"));


        int i=0;

            for (WebElement tmp : aElements) {
//                while (i <= 10) {
//                    i = i + 1;
                if ((tmp.getText().contains("Selenium")) /*&& (tmp.getText().startsWith("http"))*/) {
                    String hl = tmp.getAttribute("href");
                    System.out.println(tmp.getAttribute("href"));
                    tmp.click();

                }
//                else{
//                    System.out.println("No links contains Selenium");
//                }

 //              }


            }
        driver.close();
    }
}
