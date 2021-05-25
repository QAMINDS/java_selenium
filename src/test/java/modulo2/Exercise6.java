package modulo2;

import common.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise6 {
    public static void main(String[] args) throws InterruptedException {
    WebDriver driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserName.CHROME);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.tiktok.com/?is_copy_url=1&is_from_webapp=v1");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);

        List<WebElement> userlist = driver.findElements(By.className("jsx-3392055781 search"));

        for(WebElement list: userlist) {
            WebElement description = list.findElement(By.xpath("//p[@class='jsx-2518823583 title jsx-219294543']"));
            System.out.println(description.getText());


        }


        }
}
