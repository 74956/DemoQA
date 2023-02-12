package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public WebElement getCardElement(String cardTitle) {
        return driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]//ancestor::div[contains(@class,'top-card')]", cardTitle)));
    }

    public void clickOnCard(String cardTitle) {
        getCardElement(cardTitle).click();
    }
}
