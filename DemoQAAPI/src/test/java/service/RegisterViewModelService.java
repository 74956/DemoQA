package service;

import model.RegisterViewModel;

public class RegisterViewModelService {

    public static RegisterViewModel generateModel(String userName, String password) {
        RegisterViewModel userRegistration = new RegisterViewModel();
        userRegistration.setUserName(userName);
        userRegistration.setPassword(password);
        return userRegistration;
    }
}
