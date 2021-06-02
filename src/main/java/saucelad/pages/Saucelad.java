package saucelad.pages;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import saucelad.elements.SauceladElements;

public class Saucelad extends BasePage {

    public SauceladElements elements;



    public Saucelad(WebDriver driver, int timeout, String url) {
        super(driver, timeout, url);

        elements = new SauceladElements(driver, timeout);
    }
        @Override
        public void waitUntilLoaded() {
           this.elements.getUser();
            this.elements.getPass();
            this.elements.getBtnLogin();
        }
        public void login(String user, String pass){
            this.elements.getUser().sendKeys(user);
            this.elements.getPass().sendKeys(pass);
            this.elements.getBtnLogin().click();

        }

        public boolean IsValidUser(){
            return(this.elements.getErrorMsg() == null);
        }
    }



