package modulo4;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import common.BaseTestMultiThread;
import common.WebDriverFactory;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import saucelad.pages.Saucelad;

public class shopping extends BaseTestMultiThread {
// solo es una prueba para ver como funciona de forma directa

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private final  static  String URL = "https://www.saucedemo.com/";

    @Test
    public void testLogin() throws Exception {
        this.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.getDriver().get(URL);

        driver.findElement(By.id("login_credentials")).click();
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div")).click();

        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div[2]")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/span")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys("fer");
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys("noel");
        driver.findElement(By.id("postal-code")).click();
        driver.findElement(By.id("postal-code")).clear();
        driver.findElement(By.id("postal-code")).sendKeys("1000");
        driver.findElement(By.id("continue")).click();
        assertEquals(driver.findElement(By.xpath("//div[@id='checkout_summary_container']/div/div[2]/div[7]")).getText(), "Total: $32.39");
        driver.findElement(By.id("finish")).click();
        try {
            assertEquals(driver.getTitle(), "Swag Labs");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
