package tests;

import Enums.PathString;
import Enums.StatusCode;
import io.restassured.http.Method;
import io.restassured.response.Response;
import model.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import service.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserAndDelete {

    private String userName = "Tati123457";
    private String password = "GjuxD89Kms!";
    private RegisterViewModel registerViewModel;
    private LoginViewModel loginViewModel;
    private String userId = "020422fd-da54-4384-b097-73df507cf750";

    @Test
    public void createUserAndDelete() {
//        registerViewModel = RegisterViewModelService.generateModel(userName,password);
//        Response response = ResponseService.sendModel(Method.POST, PathString.USER_CREATE.getPath(), registerViewModel);
////        assertThat("User wasn`t created", response.getStatusCode(), Matchers.equalTo(StatusCode.CREATED.getCode()));
//        GetUserResultModal user = response.as(GetUserResultModal.class);
//        String userId = user.getUserID();
//        System.out.println(userId);
        loginViewModel = LoginViewModelService.generateModel(userName, password);
        ResponseService.sendModel(Method.POST, PathString.USER_AUTH.getPath(), loginViewModel);

        Response response = ResponseService.sendModel(Method.GET, PathString.ALL_BOOKS.getPath());
        AllBooksModal allBooksModal = response.as(AllBooksModal.class);
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
        List<String> isbnList = allBooksModal.getBooks().stream().filter(bookModal -> bookModal.getTitle().equals("Learning JavaScript Design Patterns")).map(BookModal::getIsbn).collect(Collectors.toList());
        String isbn = isbnList.stream().findAny().get();
        Response putRequest = ResponseService.sendModel(Method.PUT, PathString.BOOKS.getPath() + "/" + isbn);
        assertThat("", putRequest.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));


    }
}
