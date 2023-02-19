package utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {

    private static Waiters wait = new Waiters();

    public static int getRandomNumber(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size() - 1) + 1;
    }

    public static void clickOnElement(List<WebElement> list, String elementName) {
        wait.visibilityOfAllElements(list);
        for (WebElement webElement : list) {
            if (webElement.getText().equals(elementName)) {
                webElement.click();
            }
        }
    }

    public static List<String> getItemsNamesText(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static <T> List<T> convertToModel(String filePath, Class<T> modelType) {
        List<T> models;
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),  StandardCharsets.UTF_8.toString()))) {
            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(modelType)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            models = (List<T>) csvToBean.parse();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getCause().getMessage());
        }
        return models;
    }
}
