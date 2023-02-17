package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Util;

import java.util.List;

public class ProfilePage extends BasePage {

//    public List<WebElement> getBooksFromProfile() {
//        return driver.findElements(By.xpath("//div[@role='gridcell']//a"));
//    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//span[@id='delete-record-undefined']/*[@stroke='currentColor']"));
    }

    public WebElement getQuantityOfPage() {
        return driver.findElement(By.xpath("//span[@class='-totalPages']"));
    }

//    public List<String> getBooksTitleFromProfile() {
//        return Util.getItemsNamesText(getBooksFromProfile());
//    }

    public void deleteBook() {
        getDeleteButton().click();
    }

    public Integer quantityPagesInProfile() {
        String getQuantity = getQuantityOfPage().getText();
        return Integer.parseInt(getQuantity);
    }
}
