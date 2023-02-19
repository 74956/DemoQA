package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//span[@id='delete-record-undefined']/*[@stroke='currentColor']"));
    }

    public WebElement getQuantityOfPage() {
        return driver.findElement(By.xpath("//span[@class='-totalPages']"));
    }

    public void deleteBook() {
        getDeleteButton().click();
    }

    public Integer quantityPagesInProfile() {
        String getQuantity = getQuantityOfPage().getText();
        return Integer.parseInt(getQuantity);
    }
}
