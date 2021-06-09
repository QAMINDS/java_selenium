package module2;

import org.openqa.selenium.By;

public class TokioPage {
    public static void main(String[] args) {

       By  registry= By.xpath("//li[@class='tk-secondary-nav__item']/a[@class='tk-secondary-nav__link']");//a[@class="pk-primary-nav__link"]/span[contains(@class, "__label")]

       By  language = By.xpath("//button[@id='tk-languageButton-header']"); //span[@data-toggle="dropdown" and @type="button" and contains(@class, "pk-languages")]

        By searchBtn= By.xpath("//button[@title='Buscar']"); //input[@type="button" and @class="pk-icon-search"]

      By  tokyoLogo = By.xpath("//a[@title='Juegos Olímpicos de Tokio 2020']"); //a[@class="pk-emblem"]

        By playNow = By.xpath("//a[contains(text(),'JUGAR AHORA')][contains (@class,'mobile')]"); //div[contains(@class, "pk-fanzonebann__container-text")]/a[@data-cy="pk-fanzonebanner__container-action-v1"][3]

    }
}
