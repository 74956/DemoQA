package service;

import object.Book;
import org.openqa.selenium.WebDriver;
import pages.BookDescriptionPage;
import utils.AlertAndIframeUtil;

public class BookDescriptionPageService extends BasePageService {

    private BookDescriptionPage bookDescriptionPage;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();
    private BookStorePageService bookStorePageService;

    public BookDescriptionPageService(WebDriver driver) {
        super(driver);
        this.bookDescriptionPage = new BookDescriptionPage(driver);
    }

    public void clickOnAddBookIntoCollectionButton() {
        logger.info("Add book into collection");
        bookDescriptionPage.clickOnAddBookButton();
        alertAndIframeUtil.alertAccept();
    }

    public TableService clickOnBackToStoreButton() {
        logger.info("Come back to profile");
        bookDescriptionPage.clickOnBackToBookStoreButton();
        return new TableService(driver);
    }

    public ProfilePageService clickOnCard(String cardTitle) {
        logger.info("Click on " + cardTitle);
        bookDescriptionPage.clickOnBookStoreAppProfileElement(cardTitle);
        return new ProfilePageService(driver);
    }

    public BookStorePageService clickOnCardBookStore(String cardTitle) {
        logger.info("Click on " + cardTitle);
        bookDescriptionPage.clickOnBookStoreAppElement(cardTitle);
        return new BookStorePageService(driver);
    }

    public Book getActualBook() {
        Book book = new Book();
        book.setIsbn(bookDescriptionPage.getBookFieldsText("ISBN"));
        book.setTitle(bookDescriptionPage.getBookFieldsText("title"));
        book.setSubTitle(bookDescriptionPage.getBookFieldsText("subtitle"));
        book.setAuthor(bookDescriptionPage.getBookFieldsText("author"));
        book.setPublisher(bookDescriptionPage.getBookFieldsText("publisher"));
        book.setPages(bookDescriptionPage.getBookFieldsText("pages"));
        book.setDescription(bookDescriptionPage.getBookFieldsText("description").replaceAll("\\\\\"", "\""));
        book.setWebsite(bookDescriptionPage.getBookFieldsText("website"));
        return book;
    }

    public TableService clickOnGoToStoreButton() {
        logger.info("Come back to profile");
        bookDescriptionPage.clickOnGoToStoreButton();
        return new TableService(driver);
    }

    public LoginPageService clickOnCardLogin(String cardTitle) {
        logger.info("Click on " + cardTitle);
        bookDescriptionPage.clickOnBookStoreAppProfileElement(cardTitle);
        return new LoginPageService(driver);
    }

}
