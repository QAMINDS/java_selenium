package saucelabs.elements

import common.BaseElement
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class IndividualInventoryItemElements(
    driver: WebDriver?,
    timeout: Int
): BaseElement(driver, timeout) {

    private val DETAILS_NAME = By.xpath(".//*[@class='inventory_details_name large_size']")

    private val DETAILS_DESCRIPTION = By.xpath(".//*[@class='inventory_details_desc large_size']")

    private val DETAILS_PRICE = By.xpath(".//*[@class='inventory_details_price']")

    fun getItemDetailsName(): WebElement? {
        return this.waitUntilClickable(DETAILS_NAME)
    }

    fun getItemDetailsDescription(): WebElement? {
        return this.waitUntilClickable(DETAILS_DESCRIPTION)
    }

    fun getItemDetailsPrice(): WebElement? {
        return this.waitUntilClickable(DETAILS_PRICE)
    }
}
