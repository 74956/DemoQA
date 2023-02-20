package utils;

import newDriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public WebElement fluentWaitElementToBeVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> visibilityOfAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement visibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
