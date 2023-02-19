package service;

import org.openqa.selenium.WebDriver;
import pages.BookStorePage;


public class BookStorePageService extends BasePageService {

    private BookStorePage bookStorePage;

    public BookStorePageService(WebDriver driver) {
        super(driver);
        this.bookStorePage = new BookStorePage(driver);
    }

    public boolean isBooksTableDisplayed() {
        boolean result = bookStorePage.isBooksTableDisplayed();
        logger.info("Books table is displayed - " + result);
        return result;
    }

    public boolean isUserNameDisplayed() {
        boolean result = bookStorePage.isUserNameDisplayed();
        logger.info("User name is displayed - " + result);
        return result;
    }
}
