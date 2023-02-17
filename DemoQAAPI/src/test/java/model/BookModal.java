package model;

import java.util.Objects;

public class BookModal {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publish_date;
    private String publisher;
    private String pages;
    private String description;
    private String website;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModal bookModal = (BookModal) o;
        return Objects.equals(isbn, bookModal.isbn) && Objects.equals(title, bookModal.title) && Objects.equals(subTitle, bookModal.subTitle) && Objects.equals(author, bookModal.author) && Objects.equals(publish_date, bookModal.publish_date) && Objects.equals(publisher, bookModal.publisher) && Objects.equals(pages, bookModal.pages) && Objects.equals(description, bookModal.description) && Objects.equals(website, bookModal.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subTitle, author, publish_date, publisher, pages, description, website);
    }
}
