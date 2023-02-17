package service;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class BasePageService {

    protected static final Logger logger = LoggerFactory.getLogger(BasePageService.class);

    private BasePage basePage = new BasePage();

    public boolean isFooterDisplayedOnTheMainPage() {
        boolean result = basePage.isFooterDisplayed();
        logger.info("Footer is displayed - " + result);
        return result;
    }

    public void clickOnBookStoreAppItem(String itemName) {
        basePage.clickOnBookStoreAppItem(itemName);
        logger.info("Footer is displayed - ");
    }

    public void clickOnElementWithJavaScript(WebElement element) {
        basePage.clickOnElementWithJavaScript(element);
    }

    public void clickOnButton(String buttonText) {
        logger.info("Click on button with name - " + buttonText);
        basePage.clickOnButton(buttonText);
    }
}
