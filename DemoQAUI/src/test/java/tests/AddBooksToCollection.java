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
import utils.AlertAndIframeUtil;
import web.driver.BaseTest;

public class AddBooksToCollection extends BaseTest {

    private HomePageService homePageService = new HomePageService();
    private BookStorePageService bookStorePageService;
    private LoginPageService loginPageService;
    private BookDescriptionPageService bookDescriptionPageService;
    private ProfilePageService profilePageService;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

    @Before
    public void login(){
        User user = UserService.credentials();

        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        loginPageService = bookStorePageService.clickOnLogin();
        loginPageService.clickLogIn(user);
        loginPageService.logIn();
    }

    @Test
    public void addBooksToCollection() {
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);
        bookDescriptionPageService = bookStorePageService.addBook();
        String bookTitle = bookDescriptionPageService.getBookTitleText();
        bookDescriptionPageService.clickOnAddNewRecordButton("Add");
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
    }
}
