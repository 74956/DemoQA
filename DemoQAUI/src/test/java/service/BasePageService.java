package service;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class BasePageService {
    private BasePage basePage;
    protected WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BasePageService.class);

    public BasePageService(WebDriver driver) {
        this.driver = driver;
        this.basePage = new BasePage(driver);
    }
}
