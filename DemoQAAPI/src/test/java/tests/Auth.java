package tests;

import Enums.PathString;
import Enums.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.AllBooksModal;
import model.BookModal;
import model.RegisterViewModel;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.RegisterViewModelService;
import service.ResponseService;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class Auth {

    private ResponseService responseService = new ResponseService();
    private String userName = RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomAlphanumeric(2);
    private String password = RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomAlphanumeric(2);

    private RegisterViewModel registerViewModel;
    private String userId;

    @Test
    public void authTest() {

        Response response = ResponseService.sendModel(Method.GET, PathString.ALL_BOOKS.getPath());
        AllBooksModal allBooksModal = response.as(AllBooksModal.class);
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));

        String isbn = allBooksModal.getBooks().stream().filter(bookModal -> bookModal.getTitle().equals("Learning JavaScript Design Patterns")).map(BookModal::getIsbn).toString();

//        registerViewModel = RegisterViewModelService.generateModel(userName, password);
//        Response response = ResponseService.sendModel(Method.POST, PathString.USER_CREATE.getPath(), registerViewModel);
//        assertThat("User wasn`t created", response.getStatusCode(), Matchers.equalTo(StatusCode.CREATED.getCode()));
//
//        User user = response.as(User.class);
//        userId = user.getUserId();
//
//        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic(userName, password);
//        Response res = httpRequest.get("https://demoqa.com/Account/v1/Authorized");
//        assertThat("", res.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
//        Response resp = ResponseService.sendModelWithQueryParam(Method.DELETE, PathString.USER_CREATE.getPath(), Map.of("id", userId));
//        assertThat("User is not deleted", resp.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
//
//    }
//
//    @Test
//    public void addBooks() {
//        Response response = ResponseService.sendModel(Method.GET, String.valueOf(PathString.ALL_BOOKS), BookModal.class);
//        Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
    }
}

