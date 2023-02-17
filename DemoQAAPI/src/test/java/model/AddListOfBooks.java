package model;

import java.util.List;
import java.util.Objects;

public class AddListOfBooks {
    private String userId;
    private List<CollectionOfIsbn> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CollectionOfIsbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<CollectionOfIsbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddListOfBooks that = (AddListOfBooks) o;
        return Objects.equals(userId, that.userId) && Objects.equals(collectionOfIsbns, that.collectionOfIsbns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, collectionOfIsbns);
    }
}
