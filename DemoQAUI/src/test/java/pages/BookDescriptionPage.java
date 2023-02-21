package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookDescriptionPage extends BasePage {
    public BookDescriptionPage(WebDriver webDriver) {
        super(webDriver);
    }

    //тут оставить только кнопку о добавлении в коллекцию

    public WebElement addIntoCollectionButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'right')]//button[@id='addNewRecordButton']"));
    }

    public WebElement backToStoreButton(){
        return driver.findElement(By.xpath("//div[contains(@class,'left')]//button[@id='addNewRecordButton']"));
    }

    public WebElement getBookFields(String label) {
        String BOOK_LABEL_TEXT = "/parent::div/following-sibling::div/label[@id='userName-value']";
        return driver.findElement(By.xpath(String.format("//label[contains(@id,'%s')]", label) + BOOK_LABEL_TEXT));
    }

    public WebElement goToStoreButton(){
        return driver.findElement(By.xpath("//button[@id='gotoStore']"));
    }

    public void clickOnAddBookButton() {
        wait.fluentWaitElementToBeVisible(addIntoCollectionButton());
        scrollToElement(addIntoCollectionButton());
        clickOnElementWithJavaScript(addIntoCollectionButton());
    }

    public void clickOnBackToBookStoreButton() {
        wait.fluentWaitElementToBeVisible(backToStoreButton());
        scrollToElement(backToStoreButton());
        clickOnElementWithJavaScript(backToStoreButton());
    }

    public String getBookFieldsText(String label) {
        return getBookFields(label).getText();
    }

    public WebElement getBookStoreAppElement(String cardTitle) {
        return driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]/parent::li", cardTitle)));
    }

    public void clickOnBookStoreAppElement(String cardTitle) {
        wait.visibilityOfElement(getBookStoreAppElement(cardTitle));
        getBookStoreAppElement(cardTitle).click();
    }

    public void clickOnGoToStoreButton(){
        clickOnElementWithJavaScript(goToStoreButton());
    }
}
