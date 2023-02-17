package service;

import org.openqa.selenium.WebDriver;
import pages.BookDescriptionPage;
import utils.AlertAndIframeUtil;

public class BookDescriptionPageService extends BasePageService {

    private BookDescriptionPage bookDescriptionPage;
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

    public BookDescriptionPageService(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddNewRecordButton(String buttonText) {
        logger.info("Click on " + buttonText + " button");
        bookDescriptionPage.clickOnAddNewRecordButton(buttonText);
        alertAndIframeUtil.alertAccept();
    }

    public String getBookTitleText() {
        String bookName = bookDescriptionPage.getBookTitle();
        logger.info("The book name is - " + bookName);
        return bookName;
    }

    public ProfilePageService clickOnCard(String cardTitle) {
        logger.info("Click on " + cardTitle);
        bookDescriptionPage.clickOnBookStoreAppElement(cardTitle);
        return new ProfilePageService();
    }

}
