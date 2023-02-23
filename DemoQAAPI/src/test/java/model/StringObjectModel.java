package model;

import java.util.Objects;

public class StringObjectModel {

    private String userID;
    private String isbn;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringObjectModel that = (StringObjectModel) o;

        if (!Objects.equals(userID, that.userID)) return false;
        return Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }
}
