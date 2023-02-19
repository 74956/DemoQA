package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Util;

import java.util.List;

public class Table extends BasePage {
    public Table(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getBooksFromProfile() {
        return driver.findElements(By.xpath("//div[@role='gridcell']//a"));
    }

    public List<WebElement> getBooks() {
        return driver.findElements(By.xpath("//div[contains(@class,'ReactTable')]//a[contains(@href,'books')]"));
    }

    public List<String> getBooksTitleFromProfile() {
        return Util.getItemsNamesText(getBooksFromProfile());
    }

    public List<WebElement> listOfBooks() {
        return getBooks();
    }

    //тут все методы работы с таблицами. добавить на ур сервисов
}
