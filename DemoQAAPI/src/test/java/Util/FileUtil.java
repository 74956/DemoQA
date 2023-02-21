package Util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtil {

//    public static <T> List<T> convertToModel(String filePath, Class<T> modelType) {
//        List<T> models;
//        File file = new File(filePath);
//        CsvMapper csvMapper = new CsvMapper();
//        CsvSchema csvSchema = csvMapper
//                .typedSchemaFor(Class.class)
//                .withHeader()
//                .withColumnSeparator(',')
//                .withComments();
//        try {
//            MappingIterator<T> model = csvMapper
//                    .readerWithTypedSchemaFor(Class.class)
//                    .with(csvSchema)
//                    .readValues(file);
//            models = model.readAll();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return models;
//    }

    public <T> List<T> readMapped(File file, Class<T> clazz, int skipLines) {
        List<T> beans = null;
        try {
            beans = new CsvToBeanBuilder<T>(
                    new FileReader(file))
                    .withType(clazz).withSkipLines(skipLines)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (IllegalStateException | IOException e) {

        }
        return beans;
    }
}
