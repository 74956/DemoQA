package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

public class BasePage {
    protected static WebDriver driver;
    protected Waiters wait = new Waiters();

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement getFooter() {
        return driver.findElement(By.xpath("//footer"));
    }

    public WebElement getBookstoreAppItem(String itemName) {
        return driver.findElement(By.xpath(String.format("//div[contains(@class,'collapse show')]//li[.//span[text()='%s']]",
                itemName)));
    }

    public WebElement getDeletionPopUp(String buttonText) {
        return driver.findElement(By.xpath(String.format("//button[contains(text(),'%s')]", buttonText)));
    }

    public boolean isFooterDisplayed() {
        return getFooter().isDisplayed();
    }

    public void clickOnBookStoreAppItem(String itemName) {
        getBookstoreAppItem(itemName).click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickOnElementWithJavaScript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
