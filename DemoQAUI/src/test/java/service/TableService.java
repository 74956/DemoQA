package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Table;
import utils.AlertAndIframeUtil;
import utils.Util;

import java.util.List;

public class TableService extends BasePageService {
    private Table table;
    private BookDescriptionPageService bookDescriptionPageService;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

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

    public void clickOnNextButton(){
        logger.info("Go to the next page");
        table.clickOnNextButton();
    }

    public ProfilePageService clickOnAddedBook(String bookName){
        logger.info("Open added book description");
        table.clickOnAddedBook(bookName);
        return new ProfilePageService(driver);
    }

    private Integer pagesWithBooks() {
        return table.quantityPagesInProfile();
    }

    public void deleteBook(String bookTitleDelete) {
        List<String> booksTitle = getBooksFromProfileTable();
        for (String s : booksTitle) {
            if (s.equals(bookTitleDelete)) {
                logger.info("Delete book - " + bookTitleDelete);
                deleteElement();
            } else {
                if (pagesWithBooks() > 1) {
                    clickOnNextButton();
                    List<String> booksTitleOnOtherPage = getBooksFromProfileTable();
                    for (String title : booksTitleOnOtherPage) {
                        if (title.equals(bookTitleDelete)) {
                            logger.info("Delete book - " + title);
                            deleteElement();
                        }
                    }
                }
            }
        }
    }

    private void deleteElement() {
        table.deleteBook();
        alertAndIframeUtil.alertAccept();
    }

    public List<String> getBooksFromProfileTable(){
        List<WebElement> books = table.listOfAddedBooks();
        return Util.getItemsNamesText(books);
    }

    public boolean isListOfBookInProfileEmpty(){
        boolean result = table.isAnyBookExistInTable();
        logger.info("Table with books is empty - " + result);
        return result;
    }
}
