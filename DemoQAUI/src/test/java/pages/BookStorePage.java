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

    public WebElement getBookStoreAppElement(String cardTitle) {
        return driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]/parent::li", cardTitle)));
    }

    public void clickOnBookStoreAppElement(String cardTitle) {
        wait.visibilityOfElement(getBookStoreAppElement(cardTitle));
        getBookStoreAppElement(cardTitle).click();
    }
}
