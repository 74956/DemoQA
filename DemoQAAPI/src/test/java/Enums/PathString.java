package Enums;

public enum PathString {

    SITE_URL("https://demoqa.com/"),
    ALL_BOOKS("/BookStore/v1/Books"),
    USER_AUTH("/Account/v1/Authorized"),
    REGISTER_PATH("register"),
    LOGIN_PATH("login");

    private final String path;

    PathString(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

}
