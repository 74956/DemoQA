package service;

import pages.ProfilePage;
import utils.AlertAndIframeUtil;

import java.util.List;

public class ProfilePageService extends BasePageService {
    private ProfilePage profilePage = new ProfilePage();
    private AlertAndIframeUtil alertAndIframeUtil = new AlertAndIframeUtil();

    public List<String> bookTitlesList() {
        logger.info("Get list of books title added to profile");
        return profilePage.getBooksTitleFromProfile();
    }

    public void deleteBook(String bookTitleDelete) {
        List<String> booksTitle = bookTitlesList();
        for (String s : booksTitle) {
            if (s.equals(bookTitleDelete)) {
                logger.info("Delete book - " + bookTitleDelete);
                deleteElement();
            } else {
                if (pagesWithBooks() > 1) {
                    clickOnButton("Next");
                    List<String> booksTitles = bookTitlesList();
                    for (String title : booksTitles) {
                        if (title.equals(bookTitleDelete)) {
                            logger.info("Delete book - " + title);
                            deleteElement();
                        }
                    }
                }
            }
        }
    }

    public boolean ifBookExitInCollection(String bookTitle) {
        List<String> listOfBooks = bookTitlesList();
        for (String s : listOfBooks) {
            if (s.equals(bookTitle)) {
                logger.info("Added book - " + s);
                return true;
            } else {
                if (pagesWithBooks() > 1) {
                    clickOnButton("Next");
                    List<String> booksTitles = bookTitlesList();
                    for (String title : booksTitles) {
                        if (title.equals(bookTitle)) {
                            logger.info("Added book - " + title);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    private Integer pagesWithBooks() {
        return profilePage.quantityPagesInProfile();
    }

    private void deleteElement() {
        profilePage.deleteBook();
        clickOnButton("OK");
        alertAndIframeUtil.alertAccept();
    }
}
