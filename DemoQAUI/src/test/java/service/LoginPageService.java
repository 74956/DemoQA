package service;

import object.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageService extends BasePageService {
    private LoginPage loginPage;

    public LoginPageService(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }

    public BookStorePageService clickLogIn(User user) {
        logger.info("Input user name");
        loginPage.inputUserName(user.getUserName());
        logger.info("Input user password");
        loginPage.inputUserPassword(user.getPassword());
        loginPage.getLogin();
        return new BookStorePageService(driver);
    }
    public LoginPageService logIn() {
        logger.info("Click on Login button");
        loginPage.clickOnLogin();
        return new LoginPageService(driver);
    }
}
