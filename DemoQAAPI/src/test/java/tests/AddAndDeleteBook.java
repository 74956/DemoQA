package tests;

import io.restassured.http.Method;
import io.restassured.response.Response;
import model.AddListOfBooks;
import model.AllBooksModal;
import model.BookModal;
import model.CollectionOfIsbn;
import model.LoginViewModel;
import model.RegisterViewModel;
import model.TokenViewModel;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import service.AddListOfBooksService;
import service.CollectionOfIsbnService;
import service.LoginViewModelService;
import service.ResponseService;


import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddAndDeleteBook {

    private String userName = "Ta1233410";
    private String password = "Ta12ab33!";
    private RegisterViewModel registerViewModel;
    private LoginViewModel loginViewModel;
    private String userId = "63400f90-3da5-44eb-a764-60064ef66a38";

    @Test //auth service, book service, account service, base service(get request spec. given - content type )
    public void addBook() { // token токен вынести в baseTest инициализация в виде переменной. Токен как модель. сделать
        //энпоинты и сервисы. отдельно на блоки разделить. статус коды в методы на уровнях сервисов
        //все методы не статические. и реализация через рефлексию и constructorUtils
        loginViewModel = LoginViewModelService.generateModel(userName, password);
        String token = ResponseService.sendModel(Method.POST, PathString.TOKEN.getPath(), loginViewModel).
                as(TokenViewModel.class).getToken();
        System.out.println(token);


        Response response = ResponseService.sendModel(Method.GET, PathString.ALL_BOOKS.getPath());
        AllBooksModal allBooksModal = response.as(AllBooksModal.class);
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
        List<String> isbnList = allBooksModal.getBooks().stream().filter(bookModal -> bookModal.getTitle().
                equals("Learning JavaScript Design Patterns")).map(BookModal::getIsbn).collect(Collectors.toList());
        String isbn = isbnList.stream().findAny().get();

        CollectionOfIsbn collectionOfIsbn = CollectionOfIsbnService.generateModel(isbn);
        AddListOfBooks addListOfBooks = AddListOfBooksService.generateModel(userId, collectionOfIsbn);
        Response putRequest = ResponseService.sendModel(Method.POST, PathString.BOOKS.getPath(), addListOfBooks, token);
        assertThat("Book is not added", putRequest.getStatusCode(), Matchers.equalTo(StatusCode.CREATED.getCode()));
    }
}
