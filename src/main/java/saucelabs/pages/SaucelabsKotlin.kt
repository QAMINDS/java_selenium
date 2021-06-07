package saucelabs.pages

import common.BasePage
import google.elements.GoogleElements
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import saucelabs.elements.SaucelabsElements
import java.lang.Exception

class SaucelabsKotlin(driver: WebDriver?, timeout: Int, url: String?) : BasePage(driver, timeout, url) {

    var elements: SaucelabsElements = SaucelabsElements(driver, timeout)


    override fun waitUntilLoaded() {
        elements.userNameEditText
        elements.passwordEditText
        elements.loginButton
    }

    fun login(username: String, password: String) {
        enterUsername(username)
        enterPassword(password)
        clickLoginButton()
    }

    fun loginAndGoToProducts(username: String, password: String): Product {
        enterUsername(username)
        enterPassword(password)
        clickLoginButton()
        return Product(driver, 5)
    }

    fun enterUsername(username: String) {
        elements.userNameEditText.sendKeys(username)
    }

    fun enterPassword(password: String) {
        elements.passwordEditText.sendKeys(password)
    }

    fun clickLoginButton() {
        elements.loginButton.click()
    }

    fun isUserValid(): Boolean {
        return elements.errorMessage?.let {  false } ?: true
    }
}