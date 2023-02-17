package web.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static WebDriver driver;

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
