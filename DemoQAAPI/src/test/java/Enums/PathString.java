package Enums;

public enum PathString {

    SITE_URL("https://demoqa.com/"),

    TOKEN("/Account/v1/GenerateToken"),
    USER_AUTH("/Account/v1/Authorized"),


    private final String path;

    PathString(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

}
