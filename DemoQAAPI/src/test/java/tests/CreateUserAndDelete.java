package tests;

import Enums.PathString;
import Enums.StatusCode;
import io.restassured.http.Method;
import io.restassured.response.Response;
import model.LoginViewModel;
import model.RegisterViewModel;
import model.User;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import service.LoginViewModelService;
import service.RegisterViewModelService;
import service.ResponseService;


import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserAndDelete {

    private String userName = "Tati12345";
    private String password = "GjuxD89Kms!";
    private RegisterViewModel registerViewModel;
    private LoginViewModel loginViewModel;

    @Test
    public void createUserAndDelete(){
        registerViewModel = RegisterViewModelService.generateModel(userName,password);
        Response response = ResponseService.sendModel(Method.POST, PathString.USER_CREATE.getPath(), registerViewModel);
        assertThat("User wasn`t created", response.getStatusCode(), Matchers.equalTo(StatusCode.CREATED.getCode()));
        User user = response.as(User.class);
        String userId = user.getUserId();
        System.out.println(userId);
//        loginViewModel = LoginViewModelService.generateModel(userName, password);
//        ResponseService.sendModel(Method.POST, PathString.USER_AUTH.getPath(), loginViewModel);


    }
}
