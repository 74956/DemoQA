package service;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageService extends BasePageService {
    private HomePage homePage;

    public HomePageService(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage(driver);
    }

    public BookStorePageService clickOnCard(String cardTitle) {
        logger.info("Click on " + cardTitle);
        homePage.clickOnCardFromHomePage(cardTitle);
        return new BookStorePageService(driver);
    }
}
