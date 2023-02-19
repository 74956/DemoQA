package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getBooksTable() {
        return driver.findElement(By.xpath("//div[@role='grid']"));
    }

    public WebElement getVisibilityOfUserName() {
        return driver.findElement(By.xpath("//label[@id='userName-value']"));
    }

    public boolean isBooksTableDisplayed() {
        return getBooksTable().isDisplayed();
    }

    public boolean isUserNameDisplayed() {
        return getVisibilityOfUserName().isDisplayed();
    }
}
