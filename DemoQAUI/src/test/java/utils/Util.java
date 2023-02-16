package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {
    private BasePage basePage = new BasePage();

    private static Waiters wait = new Waiters();

    public static int getRandomNumber(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size() - 1) + 1;
    }

    public void clickOnRandomElement(List<WebElement> list) {
        wait.visibilityOfAllElements(list);
        int randomNumber = getRandomNumber(list);
        wait.fluentWaitElementToBeClickable(list.get(randomNumber));
        basePage.clickOnElementWithJavaScript(list.get(randomNumber));
    }

    public static List<String> getItemsNamesText(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
