package Enums;

public enum PathString {

    SITE_URL("https://demoqa.com/"),
    ALL_BOOKS("/BookStore/v1/Books"),
    TOKEN("/Account/v1/GenerateToken"),
    USER_CREATE("/Account/v1/User"),
    USER_AUTH("/Account/v1/Authorized"),
    DELETE_USER("/Account/v1/User/{id}");

    private final String path;

    PathString(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

}
