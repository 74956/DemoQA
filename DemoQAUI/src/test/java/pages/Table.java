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

//    public void clickOnAddedBook(String bookName) {
//       getAddedBookFromProfile(bookName).click();
//    }

    public List<WebElement> listOfBooks() {
        return getBooks();
    }

    public void deleteBook(String bookName) {
        getDeleteButton(bookName).click();
    }

}
