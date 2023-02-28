package tests;

import util.GetProperties;
import model.*;
import org.testng.annotations.Test;
import service.account.AccountService;
import service.book.BookNoneAuthService;
import service.book.BookService;

public class AddAndDeleteBookTest extends BaseTest{

    private BookNoneAuthService bookNoneAuthService;
    private AccountService accountService;
    private CollectionOfIsbn collectionOfIsbn;
    private final String userId = GetProperties.getProperties("credentials", "userId");

    @Test
    public void addAndDeleteBook() {
//        LoginViewModel loginViewModel = AccountService.generateModel(userName, password);

        bookNoneAuthService = new BookNoneAuthService();
        AllBooksModal allBooksModal = bookNoneAuthService.getBooks();
        String isbn = bookNoneAuthService.getBookIsbn(allBooksModal, "Learning JavaScript Design Patterns");
        System.out.println(isbn);
//        BookService bookService = new BookService(token);
//        accountService = new AccountService();
//        accountService.authorized(loginViewModel);
        BookService bookService = invokeService(BookService.class, token);
        AddListOfBooks addListOfBooks = bookService.generateAddListOfBooksModel(userId, isbn);
        collectionOfIsbn = bookService.addBook(addListOfBooks);
        collectionOfIsbn = bookService.deleteBook(userId);
    }
}
