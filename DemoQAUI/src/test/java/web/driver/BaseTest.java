package web.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
        Driver.waiters();
    }

    @After
    public void stopBrowser() {
        Driver.closeBrowser();
    }
}
