package Util;

public enum PathString {

    URL("https://demoqa.com/"),
    ALL_BOOKS("/BookStore/v1/Books");

    PathString(String path) {
        this.path = path;
    }

    private final String path;

    public String getPath() {
        return path;
    }

}
