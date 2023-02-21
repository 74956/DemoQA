package service;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;
import utils.AlertAndIframeUtil;

import java.util.List;

public class ProfilePageService extends BasePageService {
    private ProfilePage profilePage;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

    public ProfilePageService(WebDriver driver) {
        super(driver);
        this.profilePage = new ProfilePage(driver);
    }

    public LoginPage logout(){
        logger.info("Log out from account");
        profilePage.clickOnLogout();
        return new LoginPage(driver);
    }
}
