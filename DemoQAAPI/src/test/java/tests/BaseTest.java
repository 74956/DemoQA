package tests;

import util.GetProperties;
import model.LoginViewModel;
import model.TokenViewModel;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.testng.annotations.BeforeClass;
import service.account.AccountService;
import service.auth.AuthService;
import service.base.BaseService;

public class BaseTest {

    protected TokenViewModel token;
    String userName = GetProperties.getProperties("credentials", "userName");
    String password = GetProperties.getProperties("credentials", "password");
    private AuthService authService;
    private LoginViewModel loginViewModel;

    @BeforeClass
    public void before() {
        loginViewModel = AccountService.generateModel(userName, password);
        authService = new AuthService();
        token = authService.getToken(loginViewModel);
    }

    protected <T extends BaseService> T invokeService(Class<T> clazz, TokenViewModel token) {
        T service;
        try {
            service = ConstructorUtils.invokeConstructor(clazz, token);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not create '%s' service with token!", clazz.getSimpleName()));
        }
        return service;
    }

}
