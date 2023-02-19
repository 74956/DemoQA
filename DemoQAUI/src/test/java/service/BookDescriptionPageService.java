package service;

import object.Book;
import org.openqa.selenium.WebDriver;
import pages.BookDescriptionPage;
import utils.AlertAndIframeUtil;

public class BookDescriptionPageService extends BasePageService {

    private BookDescriptionPage bookDescriptionPage;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

    public BookDescriptionPageService(WebDriver driver) {
        super(driver);
        this.bookDescriptionPage = new BookDescriptionPage(driver);
    }

    public void clickOnAddBookIntoCollectionButton() {
        logger.info("Add book into collection");
        bookDescriptionPage.clickOnAddBookButton();
        alertAndIframeUtil.alertAccept();
    }

    public ProfilePageService clickOnCard(String cardTitle) {
        logger.info("Click on " + cardTitle);
        bookDescriptionPage.clickOnBookStoreAppElement(cardTitle);
        return new ProfilePageService(driver);
    }

    public Book getActualBook() {
        Book book = new Book();
        book.setIsbn(bookDescriptionPage.getBookFieldsText("ISBN"));
        book.setTitle(bookDescriptionPage.getBookFieldsText("title"));
        book.setSubTitle(bookDescriptionPage.getBookFieldsText("subtitle"));
        book.setAuthor(bookDescriptionPage.getBookFieldsText("author"));
        book.setPublisher(bookDescriptionPage.getBookFieldsText("publisher"));
        book.setPages(bookDescriptionPage.getBookFieldsText("pages"));
        book.setDescription(bookDescriptionPage.getBookFieldsText("description"));
        book.setWebsite(bookDescriptionPage.getBookFieldsText("website"));
        return book;
    }

}
