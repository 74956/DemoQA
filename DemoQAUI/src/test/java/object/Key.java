package object;

import java.util.Objects;

public class Key {
    private String bookKey;

    public Key(String bookKey) {
        this.bookKey = bookKey;
    }

    public String getBookKey() {
        return bookKey;
    }

    public void setBookKey(String bookKey) {
        this.bookKey = bookKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(bookKey, key.bookKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookKey);
    }

    @Override
    public String toString() {
        return "Key{" +
                "bookKey='" + bookKey + '\'' +
                '}';
    }
}
