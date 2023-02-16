package utils;

import org.openqa.selenium.WebDriver;
import web.driver.Driver;

public class AlertAndIframeUtil {

    protected WebDriver driver;
    private Waiters waiters = new Waiters();

    public AlertAndIframeUtil() {
        this.driver = Driver.getDriver();
    }

    public void alertAccept() {
        waiters.waitTillAlertIsNotPresent();
        driver.switchTo().alert().accept();
    }
}
