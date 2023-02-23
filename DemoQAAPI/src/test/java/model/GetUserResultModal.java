package model;

import java.util.List;
import java.util.Objects;

public class GetUserResultModal {

    private String userID;
    private String username;
    private List<BookModal> books;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BookModal> getBooks() {
        return books;
    }

    public void setBooks(List<BookModal> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetUserResultModal that = (GetUserResultModal) o;

        if (!Objects.equals(userID, that.userID)) return false;
        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
