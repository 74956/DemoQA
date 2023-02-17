package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getCardElementFromHomePage(String cardTitle) {
        return driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]//ancestor::div[contains(@class,'top-card')]", cardTitle)));
    }

    public void clickOnCardFromHomePage(String cardTitle) {
        getCardElementFromHomePage(cardTitle).click();
    }
}
