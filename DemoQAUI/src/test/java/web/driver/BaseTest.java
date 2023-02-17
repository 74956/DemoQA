package web.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import service.BasePageService;

public class BaseTest {

    private BasePageService basePageService;

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
        Driver.waiters();
    }

    @AfterClass
    public void stopBrowser() {
        Driver.closeBrowser();
    }
}
