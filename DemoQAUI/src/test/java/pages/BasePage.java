package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.driver.Driver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public WebElement getFooter() {
        return driver.findElement(By.xpath("//footer"));
    }

    public boolean isFooterDisplayed() {
        return getFooter().isDisplayed();
    }
}
