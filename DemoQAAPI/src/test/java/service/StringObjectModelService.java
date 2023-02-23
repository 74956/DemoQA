package service;

import model.StringObjectModel;

public class StringObjectModelService {

    public static StringObjectModel generateModel(String userID, String isbn) {
        StringObjectModel stringObjectModel = new StringObjectModel();
        stringObjectModel.setUserID(userID);
        stringObjectModel.setIsbn(isbn);
        return stringObjectModel;
    }
}
