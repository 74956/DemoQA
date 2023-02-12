package service;

import pages.HomePage;

public class HomePageService extends BasePageService {
    private HomePage homePage = new HomePage();

    public BookStorePageService clickOnCard(String cardTitle) {
        logger.info("Click on " + cardTitle);
        homePage.clickOnCard(cardTitle);
        return new BookStorePageService();
    }
}
