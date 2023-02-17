package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.driver.Driver;

import java.time.Duration;
import java.util.List;

public class Waiters {

    protected WebDriver driver;

    public Waiters() {
        this.driver = Driver.getDriver();
    }

    public Alert waitTillAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement fluentWaitElementToBeClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public List<WebElement> visibilityOfAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
