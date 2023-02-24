package service.base;

public enum BaseEndpoint {

    SITE_URL("https://demoqa.com/");

    private final String path;
    BaseEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


}
