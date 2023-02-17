package tests;

import object.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.BookDescriptionPageService;
import service.BookStorePageService;
import service.HomePageService;
import service.LoginPageService;
import service.ProfilePageService;
import service.UserService;
import web.driver.BaseTest;

import java.util.List;

public class BookInCollection extends BaseTest {

    private final HomePageService homePageService = new HomePageService();
    private BookStorePageService bookStorePageService;
    private LoginPageService loginPageService;
    private BookDescriptionPageService bookDescriptionPageService;
    private ProfilePageService profilePageService;
    private String bookTitle;

    @BeforeClass
    public void login() {
        User user = UserService.credentials();

        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        loginPageService = bookStorePageService.clickOnLogin();
        loginPageService.clickLogIn(user);
        loginPageService.logIn();
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);
        bookDescriptionPageService = bookStorePageService.clickOnRandomBook();
        bookTitle = bookDescriptionPageService.getBookTitleText();
        bookDescriptionPageService.clickOnAddNewRecordButton("Add");
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
    }

    @Test
    public void addBooksToCollection() {
        boolean result = profilePageService.ifBookExitInCollection(bookTitle);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteBooksFromCollection() {
        profilePageService.deleteBook(bookTitle);
        List<String> actualListOfBooksTitle = profilePageService.bookTitlesList();
        Assert.assertFalse(actualListOfBooksTitle.contains(bookTitle));
    }
}
