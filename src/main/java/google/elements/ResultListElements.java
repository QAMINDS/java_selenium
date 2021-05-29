package google.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultListElements extends BaseElement {
    private final static By RESULTS = By.xpath("//*[@class='g' and  not(ancestor::g-accordion-expander)]");

    public ResultListElements(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public List<WebElement> getResultDivs() {
        return this.waitForElements(RESULTS);
    }
}
