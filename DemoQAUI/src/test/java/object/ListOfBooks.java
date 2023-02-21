package object;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfBooks {

    private String key;
    private List<Book> books;

//    public ListOfBooks(String row) {
//        String[] data = row.split(";");
//        this.key = data[0];
//        this.books = Arrays.stream(data, 1, data.length)
//                .map(item -> item.lines())
//                .collect(Collectors.toList());
//    }
}
