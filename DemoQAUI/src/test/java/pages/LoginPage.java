package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getUserName() {
        return driver.findElement(By.xpath("//input[@id='userName']"));
    }

    public WebElement getUserPassword() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public void inputUserName(String userName) {
        getUserName().clear();
        getUserName().sendKeys(userName);
    }

    public void inputUserPassword(String password) {
        getUserPassword().clear();
        getUserPassword().sendKeys(password);
    }

    //from basepage
//    public void clickLogIn() {
//        clickOnLogin();
//    }

}
