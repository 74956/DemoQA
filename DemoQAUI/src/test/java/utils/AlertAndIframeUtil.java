package utils;

import newDriver.Driver;
import org.openqa.selenium.WebDriver;

public class AlertAndIframeUtil {

    protected WebDriver driver;
    private final Waiters waiters = new Waiters();

    public AlertAndIframeUtil() {
        this.driver = Driver.getDriver();
    }

    public void alertAccept() {
        waiters.waitTillAlertIsPresent();
        driver.switchTo().alert().accept();
    }
}
