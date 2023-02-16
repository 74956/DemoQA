package service;

import org.openqa.selenium.WebElement;
import pages.BookStorePage;
import utils.Util;

import java.util.List;

public class BookStorePageService extends BasePageService {

    private BookStorePage bookStorePage = new BookStorePage();

    public boolean isBooksTableDisplayed() {
        boolean result = bookStorePage.isBooksTableDisplayed();
        logger.info("Books table is displayed - " + result);
        return result;
    }

    public LoginPageService clickOnLogin() {
        logger.info("Click on Login button");
        bookStorePage.clickOnLoginButton();
        return new LoginPageService();
    }

    public boolean isUserNameDisplayed() {
        boolean result = bookStorePage.isUserNameDisplayed();
        logger.info("User name is displayed - " + result);
        return result;
    }

    public BookDescriptionPageService addBook() {
        logger.info("Add random book to collection");
        List<WebElement> listOfBooks = bookStorePage.listOfBooks();
        Util.clickOnRandomElement(listOfBooks);
        return new BookDescriptionPageService();
    }
}
