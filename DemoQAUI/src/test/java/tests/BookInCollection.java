package tests;

import newDriver.BaseTest;
import object.Book;
import object.User;
import org.hamcrest.Matchers;
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
import utils.CsvReader;
import utils.Util;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookInCollection extends BaseTest {

    private BookDescriptionPageService bookDescriptionPageService;
    private ProfilePageService profilePageService;
    private TableService tableService;
    private String bookName = "You Don't Know JS";

    @BeforeClass
    public void login() {

        HomePageService homePageService = new HomePageService(driver);
        BookStorePageService bookStorePageService;
        LoginPageService loginPageService = new LoginPageService(driver);
        tableService = new TableService(driver);

        User user = UserService.credentials();

        bookStorePageService = homePageService.clickOnCard("Book Store Application");
        loginPageService.logIn();
        loginPageService.clickLogIn(user);
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);
        bookDescriptionPageService = tableService.clickOnBook(bookName);
        bookDescriptionPageService.clickOnAddBookIntoCollectionButton();
    }

    @Test
    public void addBooksToCollection() {
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
        tableService.clickOnAddedBook(bookName);
        Book actualBook = bookDescriptionPageService.getActualBook();

        File file = new File("src/main/resources/book.csv");
        List<Book> books = CsvReader.readMapped(file, Book.class, 0);
        Book expectedBook = books.get(0);
        assertThat("Books are not equal", actualBook, Matchers.equalTo(expectedBook));
    }

    @Test
    public void deleteBooksFromCollection() {
        tableService.deleteBook(bookTitle);
        List<String> actualListOfBooksTitle = profilePageService.bookTitlesList();
        Assert.assertFalse(actualListOfBooksTitle.contains(bookTitle)); //логин, добавить и проверить, что удалена, полно
    }

    //удалить книгу. с помощью апи. log out
}
