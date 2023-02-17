package service;

import object.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageService extends BasePageService {
    private LoginPage loginPage;
    protected WebDriver driver;

    public LoginPageService(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }

    public void clickLogIn(User user) {
        logger.info("Input user name");
        loginPage.inputUserName(user.getUserName());
        logger.info("Input user password");
        loginPage.inputUserPassword(user.getPassword());
    }
    public BookStorePageService logIn() {
        logger.info("Click on Login button");
        loginPage.clickLogIn();
        return new BookStorePageService(driver);
    }
}
