package google.elements;

import common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultItemElements extends BaseElement {
    private final static By CITE = By.xpath(".//cite");

    private final static By TITLE = By.xpath(".//h3");

    public ResultItemElements(WebDriver driver, int timeout, WebElement root) {
        super(driver, timeout, root);
    }

    public WebElement getCite() {
        return this.waitUntilSubElementVisible(CITE);
    }

    public WebElement getTitle() {
        return this.waitUntilSubElementVisible(TITLE);
    }
}
