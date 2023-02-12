package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookStorePage extends BasePage {

    public WebElement getBooksTable() {
        return driver.findElement(By.xpath("//div[@role='grid']"));
    }

    public boolean isBooksTableDisplayed() {
        return getBooksTable().isDisplayed();
    }

}
