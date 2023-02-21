package utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class CsvReader {

    public static  <T> List<T> readMapped(File file, Class<T> clazz, int skipLines) {
        List<T> beans;
        try {
            beans = new CsvToBeanBuilder<T>(
                    new FileReader(file))
                    .withType(clazz).withSkipLines(skipLines)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
        return beans;
    }
}
