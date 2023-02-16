package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;

public class ProfilePage extends BasePage {

    public List<WebElement> getBooksFromProfile() {
        return driver.findElements(By.xpath("//a[contains(@href,'profile?book')]"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//span[@id='delete-record-undefined']"));
    }

    public List<String> getBooksTitleFromProfile() {
        return Util.getItemsNamesText(getBooksFromProfile());
    }

    public void deleteBook(){
        getDeleteButton().click();
    }
}
