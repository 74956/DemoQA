package service;

import model.LoginViewModel;

public class LoginViewModelService {

    public static LoginViewModel generateModel(String userName, String password) {
        LoginViewModel loginModel = new LoginViewModel();
        loginModel.setUserName(userName);
        loginModel.setPassword(password);
        return loginModel;
    }
}
