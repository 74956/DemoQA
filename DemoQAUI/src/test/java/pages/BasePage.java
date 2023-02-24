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

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickOnElementWithJavaScript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getBookAppElement(String cardTitle) {
        return String.format("//*[text()='%s']/parent::li", cardTitle);
    }

    public WebElement getBookStoreAppProfileElement(String cardTitle) {
        String BOOK_APP_ELEMENT = getBookAppElement(cardTitle);
        return driver.findElement(By.xpath(BOOK_APP_ELEMENT));
    }

    public void clickOnBookStoreAppProfileElement(String cardTitle) {
        wait.visibilityOfElement(getBookStoreAppProfileElement(cardTitle));
        clickOnElementWithJavaScript(getBookStoreAppProfileElement(cardTitle));
    }
}
