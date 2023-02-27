package service.book;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.AddListOfBooks;
import model.AllBooksModal;
import model.CollectionOfIsbn;
import model.TokenViewModel;
import org.apache.hc.core5.http.HttpStatus;
import service.base.BaseEndpoint;
import service.base.BaseService;

import java.util.ArrayList;
import java.util.List;

public class BookService extends BaseService {

    private final RequestSpecification requestSpecification;
    public BookService(TokenViewModel token) {
        super(token);
        this.requestSpecification = getAuthorizedRequest();
    }

    public Response chooseBook(AddListOfBooks addListOfBooks) { //либо List<String> isbn
        String baseUrl = BaseEndpoint.SITE_URL.getPath();
        String url = baseUrl + BookEndpoint.ALL_BOOKS.getUrl();
        return requestSpecification
                .when()
                .header("Content-Type",
                        ContentType.JSON)
                .body(addListOfBooks)
                .post(url);
    }

    public CollectionOfIsbn addBook(AddListOfBooks addListOfBooks){
        return chooseBook(addListOfBooks)
                .then()
                .log().everything()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(CollectionOfIsbn.class);
    }

    public Response getAllBooks() {
        String baseUrl = BaseEndpoint.SITE_URL.getPath();
        String url = baseUrl + BookEndpoint.ALL_BOOKS.getUrl();
        return requestSpecification
                .when()
                .get(url);
    }

    public AllBooksModal getBooks(){
        return getAllBooks()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(AllBooksModal.class);
    }

    public Response bookToDelete(String userId) {
        String url = BookEndpoint.ALL_BOOKS.getUrl();
        return requestSpecification
                .when()
                .body(userId)
                .delete(url);
    }

    public CollectionOfIsbn deleteBook(String userId){
        return bookToDelete(userId)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .extract()
                .as(CollectionOfIsbn.class);
    }

    public AddListOfBooks generateAddListOfBooksModel(String userId, String isbn){
        AddListOfBooks addListOfBooks = new AddListOfBooks();
        addListOfBooks.setUserId(userId);
        addListOfBooks.setCollectionOfIsbns(setBook(isbn));
        return addListOfBooks;
    }

    private List<CollectionOfIsbn> setBook(String isbn) {
        CollectionOfIsbn collectionOfIsbn = new CollectionOfIsbn();
        collectionOfIsbn.setIsbn(isbn);
        List<CollectionOfIsbn> isbns = new ArrayList<>();
        isbns.add(collectionOfIsbn);
        return isbns;
    }

}
