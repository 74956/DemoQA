package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement logout(){
        return driver.findElement(By.xpath("//div[@id='books-wrapper']//button"));
    }

    public void clickOnLogout(){
        logout().click();
    }
}
