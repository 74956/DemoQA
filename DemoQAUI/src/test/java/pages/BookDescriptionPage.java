package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

public class BookDescriptionPage extends BasePage {

    private Waiters waiters = new Waiters();
    public BookDescriptionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getBookAppElement(String cardTitle) {
        return String.format("//*[text()='%s']/parent::li", cardTitle);
    }

    public WebElement getBookStoreAppProfileElement(String cardTitle) {
        String BOOK_APP_ELEMENT = getBookAppElement(cardTitle);
        return driver.findElement(By.xpath(BOOK_APP_ELEMENT));
    }

    public WebElement getBookStoreAppElement(String cardTitle) {
        String BOOK_APP_ELEMENT = getBookAppElement(cardTitle);
        return driver.findElement(By.xpath(BOOK_APP_ELEMENT));
    }

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
        waiters.visibilityOfElement(getBookFields(label));
        return getBookFields(label).getText();
    }

    public void clickOnGoToStoreButton(){
        clickOnElementWithJavaScript(goToStoreButton());
    }

    public void clickOnBookStoreAppProfileElement(String cardTitle) {
        wait.visibilityOfElement(getBookStoreAppProfileElement(cardTitle));
        clickOnElementWithJavaScript(getBookStoreAppProfileElement(cardTitle));
    }

    public void clickOnBookStoreAppElement(String cardTitle) {
        wait.visibilityOfElement(getBookStoreAppElement(cardTitle));
        clickOnElementWithJavaScript(getBookStoreAppElement(cardTitle));
    }
}
