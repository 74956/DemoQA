package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BookStorePage;
import utils.Util;

import java.util.List;

public class BookStorePageService extends BasePageService {

    protected WebDriver driver;
    private BookStorePage bookStorePage;
    private Util util = new Util();

    public BookStorePageService(WebDriver driver) {
        super(driver);
        this.bookStorePage = new BookStorePage(driver);
    }

    public boolean isBooksTableDisplayed() {
        boolean result = bookStorePage.isBooksTableDisplayed();
        logger.info("Books table is displayed - " + result);
        return result;
    }

    public LoginPageService clickOnLogin() {
        logger.info("Click on Login button");
        bookStorePage.clickOnLoginButton();
        return new LoginPageService(driver);
    }

    public boolean isUserNameDisplayed() {
        boolean result = bookStorePage.isUserNameDisplayed();
        logger.info("User name is displayed - " + result);
        return result;
    }

    public BookDescriptionPageService clickOnRandomBook() {
        logger.info("Add random book to collection");
        List<WebElement> listOfBooks = bookStorePage.listOfBooks();
        util.clickOnRandomElement(listOfBooks);
        return new BookDescriptionPageService();
    }
}
