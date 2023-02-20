package tests;

import newDriver.BaseTest;
import object.Book;
import object.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.BookDescriptionPageService;
import service.BookStorePageService;
import service.HomePageService;
import service.LoginPageService;
import service.ProfilePageService;
import service.TableService;
import service.UserService;
import utils.Util;

import java.util.List;

public class BookInCollection extends BaseTest {

    private BookDescriptionPageService bookDescriptionPageService;
    private ProfilePageService profilePageService;

    @BeforeClass
    public void login() {

        HomePageService homePageService = new HomePageService(driver);
        BookStorePageService bookStorePageService;
        LoginPageService loginPageService = new LoginPageService(driver);
        TableService tableService = new TableService(driver);

        User user = UserService.credentials();

        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        loginPageService.logIn();
        loginPageService.clickLogIn(user);
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);
        bookDescriptionPageService = tableService.clickOnBook("You Don't Know JS");
        bookDescriptionPageService.clickOnAddBookIntoCollectionButton();
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
    }

    @Test
    public void addBooksToCollection() {
        List<Book> books = Util.convertToModel("DemoQAUI/src/main/resources/book.csv", Book.class);
        Book expectedBook = books.get(0);
        //юзер логинится добавляет книгу с опред. именем. книгу проверить полноценным объектом через csv
        Assert.assertEquals(bookDescriptionPageService.getActualBook(), expectedBook);
    }

//    @Test
//    public void deleteBooksFromCollection() {
//        profilePageService.deleteBook(bookTitle);
//        List<String> actualListOfBooksTitle = profilePageService.bookTitlesList();
//        Assert.assertFalse(actualListOfBooksTitle.contains(bookTitle)); //логин, добавить и проверить, что удалена, полно
//    }

    //удалить книгу. с помощью апи. log out
}
