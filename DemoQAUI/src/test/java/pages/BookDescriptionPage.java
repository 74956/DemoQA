package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookDescriptionPage extends BasePage {
    public BookDescriptionPage(WebDriver webDriver) {
        super(webDriver);
    }
    //тут оставить только кнопку о добавлении в коллекцию

    public WebElement getAddNewRecordButton(String buttonText) {
        return driver.findElement(By.xpath(String.format("//button[@id='addNewRecordButton' and contains(text(),'%s')]/parent::div",
                buttonText)));
    }

    public WebElement getTitle() {
        return driver.findElement(By.xpath("//div[@id='title-wrapper']//label[@id='userName-value']"));
    }

    public void clickOnAddNewRecordButton(String buttonText) {
        scrollToElement(getAddNewRecordButton(buttonText));
        getAddNewRecordButton(buttonText).click();
    }

    public String getBookTitle() {
        return getTitle().getText();
    }

    public WebElement getBookStoreAppElement(String cardTitle) {
        return driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]/parent::li", cardTitle)));
    }

    public void clickOnBookStoreAppElement(String cardTitle) {
        getBookStoreAppElement(cardTitle).click();
    }

}
