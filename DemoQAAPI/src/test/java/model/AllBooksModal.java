package model;

import java.util.List;
import java.util.Objects;

public class AllBooksModal {

    private List<BookModal> books;

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
        AllBooksModal that = (AllBooksModal) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
