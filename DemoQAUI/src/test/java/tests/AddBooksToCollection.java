package tests;

import object.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.BookDescriptionPageService;
import service.BookStorePageService;
import service.HomePageService;
import service.LoginPageService;
import service.ProfilePageService;
import service.UserService;
import web.driver.BaseTest;

import java.util.List;

public class AddBooksToCollection extends BaseTest {

    private HomePageService homePageService = new HomePageService();
    private BookStorePageService bookStorePageService;
    private LoginPageService loginPageService;
    private BookDescriptionPageService bookDescriptionPageService;
    private ProfilePageService profilePageService;
    private String bookTitle;

    @Before
    public void login() {
        User user = UserService.credentials();

        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        loginPageService = bookStorePageService.clickOnLogin();
        loginPageService.clickLogIn(user);
        loginPageService.logIn();
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);
        bookDescriptionPageService = bookStorePageService.addBook();
        bookTitle = bookDescriptionPageService.getBookTitleText();
        bookDescriptionPageService.clickOnAddNewRecordButton("Add");
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
    }

    @Test
    public void addBooksToCollection() {
        List<String> listOfBooksTitle = profilePageService.bookTitlesList();
        Assert.assertTrue(listOfBooksTitle.contains(bookTitle));
    }

    @Test
    public void deleteBooksFromCollection() {
        List<String> listOfBooksTitle = profilePageService.bookTitlesList();
        Assert.assertTrue(listOfBooksTitle.contains(bookTitle));
        profilePageService.deleteBook(bookTitle);
        Assert.assertFalse(listOfBooksTitle.contains(bookTitle));
    }
}
