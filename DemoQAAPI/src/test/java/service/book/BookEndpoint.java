package service.book;


public enum BookEndpoint {

    ALL_BOOKS("BookStore/v1/Books");

    private final String url;

    BookEndpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
