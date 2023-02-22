package tests;

import newDriver.BaseTest;
import object.Book;
import object.User;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.BookDescriptionPageService;
import service.BookStorePageService;
import service.HomePageService;
import service.LoginPageService;
import service.ProfilePageService;
import service.TableService;
import service.UserService;
import utils.CsvReader;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookInCollection extends BaseTest {

    private BookDescriptionPageService bookDescriptionPageService;
    private HomePageService homePageService;
    private BookStorePageService bookStorePageService;
    private LoginPageService loginPageService;
    private ProfilePageService profilePageService;
    private TableService tableService;
    private String firstBookName = "You Don't Know JS";
    private String secondBookName = "Learning JavaScript Design Patterns";

    @BeforeClass
    public void init(){
        bookDescriptionPageService = new BookDescriptionPageService(driver);
        homePageService = new HomePageService(driver);
        loginPageService = new LoginPageService(driver);
        tableService = new TableService(driver);
        bookStorePageService = homePageService.clickOnCard("Book Store Application");

    }
    @BeforeMethod
    public void login() {

        User user = UserService.credentials();

        loginPageService.logIn();
        loginPageService.clickLogIn(user);
        boolean userNameIsVisible = bookStorePageService.isUserNameDisplayed();
        Assert.assertTrue(userNameIsVisible);

    }

    @Test
    public void addBooksToCollection() {
        bookDescriptionPageService = tableService.clickOnBook(firstBookName);
        bookDescriptionPageService.clickOnAddBookIntoCollectionButton();
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
        List<String> actualListOfBooksTitle = tableService.getBooksFromProfileTable();
        assertThat("Book is added to collection", actualListOfBooksTitle.contains(firstBookName));
        tableService.clickOnAddedBook(firstBookName);
        Book actualBook = bookDescriptionPageService.getActualBook();

        File file = new File("src/main/resources/book.csv");
        List<Book> books = CsvReader.readMapped(file, Book.class, 0);
        Book expectedBook = books.get(0);
        assertThat("Books are not equal", actualBook, Matchers.equalTo(expectedBook));
        tableService = bookDescriptionPageService.clickOnBackToStoreButton();
        tableService.deleteBook(firstBookName);

    }

    @Test
    public void deleteBooksFromCollection() {
        loginPageService = bookDescriptionPageService.clickOnCardLogin("Login");
        bookStorePageService = bookDescriptionPageService.clickOnCardBookStore("Book Store");

        bookDescriptionPageService = tableService.clickOnBook(secondBookName);
        bookDescriptionPageService.clickOnAddBookIntoCollectionButton();
        tableService = bookDescriptionPageService.clickOnBackToStoreButton();

        bookDescriptionPageService = tableService.clickOnBook(secondBookName);
        bookDescriptionPageService.clickOnAddBookIntoCollectionButton();
        profilePageService = bookDescriptionPageService.clickOnCard("Profile");
        tableService.deleteBook(secondBookName);
        assertThat("Book wasn`t deleted from collection", tableService.isListOfBookInProfileEmpty());
    }

    @AfterMethod
    public void logOut() {
        profilePageService.logout();
    }
}
