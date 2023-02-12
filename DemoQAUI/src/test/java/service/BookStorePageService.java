package service;

import pages.BookStorePage;

public class BookStorePageService extends BasePageService {

    private BookStorePage bookStorePage = new BookStorePage();

    public boolean isBooksTableDisplayed() {
        boolean result = bookStorePage.isBooksTableDisplayed();
        logger.info("Books table is displayed - " + result);
        return result;
    }
}
