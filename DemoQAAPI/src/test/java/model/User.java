package model;

import java.util.List;
import java.util.Objects;

public class User {
    private String userId;
    private String username;

    private List<BookModal> books;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, books);
    }
}
