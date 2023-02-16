package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;
import web.driver.Driver;

public class BasePage {
    protected WebDriver driver;
    private Waiters wait = new Waiters();

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getFooter() {
        return driver.findElement(By.xpath("//footer"));
    }

    public WebElement getLogin() {
        return driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
    }

    public WebElement getBookstoreAppItem(String itemName) {
        return driver.findElement(By.xpath(String.format("//div[contains(@class,'collapse show')]//li[.//span[text()='%s']]",
                itemName)));
    }

    public boolean isFooterDisplayed() {
        return getFooter().isDisplayed();
    }

    public void clickOnLogin() {
        wait.elementToBeClickable(getLogin());
        getLogin().click();
    }

    public void clickOnBookStoreAppItem(String itemName) {
        getBookstoreAppItem(itemName).click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOnElementWithJavaScript(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
