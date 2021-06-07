package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class QAMindsExpectedConditions {
    public static ExpectedCondition<WebElement> subElementVisibility(final WebElement element, final By subLocator) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement subElement = element.findElement(subLocator);
                return subElement.isDisplayed() ? subElement : null;
            }
        };
    }

    public static ExpectedCondition<WebElement> subElementClickable(final WebElement element, final By subLocator) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement subElement = element.findElement(subLocator);
                return subElement.isDisplayed() && subElement.isEnabled() ? subElement : null;
            }
        };
    }
}
