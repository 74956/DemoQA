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
            if (s.contains(bookTitleDelete)) {
                profilePage.deleteBook();
                alertAndIframeUtil.alertAccept();
            }
        }
    }
}
