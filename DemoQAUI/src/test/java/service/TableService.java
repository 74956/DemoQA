package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Table;
import utils.Util;

import java.util.List;

public class TableService extends BasePageService {
    private Table table;
    private BookDescriptionPageService bookDescriptionPageService;

    public TableService(WebDriver driver) {
        super(driver);
        this.table = new Table(driver);
        this.bookDescriptionPageService = new BookDescriptionPageService(driver);
    }

    public BookDescriptionPageService clickOnBook(String bookName) {
        logger.info("Add book  with name - " + bookName + " into collection");
        List<WebElement> listOfBooks = table.listOfBooks();
        Util.clickOnElement(listOfBooks, bookName);
        return new BookDescriptionPageService(driver);
    }
}
