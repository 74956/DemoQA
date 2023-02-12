package tests;

import org.junit.Assert;
import org.junit.Test;
import service.BookStorePageService;
import service.HomePageService;
import web.driver.BaseTest;

public class AddBooksToCollection extends BaseTest {

    private HomePageService homePageService = new HomePageService();
    private BookStorePageService bookStorePageService;


    @Test
    public void openUrl() {
        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        boolean result = bookStorePageService.isBooksTableDisplayed();
        Assert.assertTrue(result);
    }
}
