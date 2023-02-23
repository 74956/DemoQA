package service;

import model.CollectionOfIsbn;

public class CollectionOfIsbnService {

    public static CollectionOfIsbn generateModel(String isbn) {
        CollectionOfIsbn collectionOfIsbn = new CollectionOfIsbn();
        collectionOfIsbn.setIsbn(isbn);
        return collectionOfIsbn;
    }
}
