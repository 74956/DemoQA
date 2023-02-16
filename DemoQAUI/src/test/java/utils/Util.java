package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Util {

    private static Waiters wait = new Waiters();
    public static int getRandomNumber(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size() - 1) + 1;
    }

    public static void clickOnRandomElement(List<WebElement> list) {
        int randomNumber = getRandomNumber(list);
        wait.elementToBeVisible(list.get(randomNumber));
        list.get(randomNumber).click();
    }

}
