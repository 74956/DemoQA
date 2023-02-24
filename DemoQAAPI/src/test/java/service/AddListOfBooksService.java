package service;

import model.AddListOfBooks;
import model.CollectionOfIsbn;

import java.util.ArrayList;
import java.util.List;

public class AddListOfBooksService {

    public AddListOfBooks generateModel(String userId, CollectionOfIsbn isbn) {
        List<CollectionOfIsbn> isbns = new ArrayList<>();
        isbns.add(isbn);
        AddListOfBooks addListOfBooks = new AddListOfBooks();
        addListOfBooks.setUserId(userId);
        addListOfBooks.setCollectionOfIsbns(isbns);
        return addListOfBooks;
    }
}
