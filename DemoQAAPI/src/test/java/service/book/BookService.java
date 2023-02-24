package service.book;

import io.restassured.response.Response;
import model.AddListOfBooks;
import model.CollectionOfIsbn;
import model.LoginViewModel;
import service.auth.AuthEndpoint;
import service.base.BaseEndpoint;
import service.base.BaseService;

import java.util.ArrayList;
import java.util.List;

public class BookService extends BaseService {

    public Response getAllBooks(){
        String url = BookEndpoint.ALL_BOOKS.getUrl();


    }

    public Response postBooks(CollectionOfIsbn collectionOfIsbn){
        String url = BookEndpoint.ALL_BOOKS.getUrl();


    }

    public List<CollectionOfIsbn> setBook(String isbn){
        CollectionOfIsbn collectionOfIsbn = new CollectionOfIsbn();
        collectionOfIsbn.setIsbn(isbn);
        List<CollectionOfIsbn> isbns = new ArrayList<>();
        isbns.add(collectionOfIsbn);
        return isbns;
    }

}
