package Util;

public enum PathString {

    URL("https://demoqa.com/"),
    ALL_BOOKS("/BookStore/v1/Books");

    private final String path;

    PathString(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
