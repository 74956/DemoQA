package service;

import object.User;
import pages.LoginPage;

public class LoginPageService extends BasePageService {
    private LoginPage loginPage = new LoginPage();

    public void clickLogIn(User user) {
        logger.info("Input user name");
        loginPage.inputUserName(user.getUserName());
        logger.info("Input user password");
        loginPage.inputUserPassword(user.getPassword());
    }
    public BookStorePageService logIn() {
        logger.info("Click on Login button");
        loginPage.clickLogIn();
        return new BookStorePageService();
    }
}
