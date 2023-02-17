package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public List<WebElement> getBooks() {
        return driver.findElements(By.xpath("//div[contains(@class,'ReactTable')]//a[contains(@href,'books')]"));
    }

    public boolean isBooksTableDisplayed() {
        return getBooksTable().isDisplayed();
    }

//    public void clickOnLoginButton() {
//        clickOnLogin();
//    }

    public boolean isUserNameDisplayed() {
        return getVisibilityOfUserName().isDisplayed();
    }

    public List<WebElement> listOfBooks() {
        return getBooks();
    }
}
