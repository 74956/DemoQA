package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Table extends BasePage {

    public Table(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getQuantityOfPage() {
        return driver.findElement(By.xpath("//span[@class='-totalPages']"));
    }

    public Integer quantityPagesInProfile() {
        String getQuantity = getQuantityOfPage().getText();
        return Integer.parseInt(getQuantity);
    }

    public List<WebElement> bookInTable() {
        return driver.findElements(By.xpath("//a[contains(@href,'book')]"));
    }

    public List<WebElement> getBooks() {
        return driver.findElements(By.xpath("//div[contains(@class,'ReactTable')]//a[contains(@href,'books')]"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//span[@title='Delete']/*[@stroke='currentColor']"));
    }

    public WebElement nextButton() {
        return driver.findElement(By.xpath("//div[@class='-next']/button"));
    }

    public WebElement addedBook(String bookName) {
        return driver.findElement(By.xpath(String.format("//span[contains(@id,\"%s\")]//a", bookName)));
    }

    public WebElement acceptDeleteBookButton() {
        return driver.findElement(By.xpath("//button[@id='closeSmallModal-ok']"));
    }

    public boolean isAnyBookExistInTable() {
        return bookInTable().isEmpty();
    }

    public void clickOnAddedBook(String bookName) {
        clickOnElementWithJavaScript(addedBook(bookName));
    }

    public List<WebElement> listOfBooks() {
        return getBooks();
    }

    public List<WebElement> listOfAddedBooks() {
        return bookInTable();
    }

    public void deleteBook() {
        getDeleteButton().click();
        acceptDeleteBookButton().click();
    }

    public void clickOnNextButton() {
        nextButton().click();
    }

}
