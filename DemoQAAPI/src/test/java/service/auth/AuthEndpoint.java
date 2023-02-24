package service.auth;

public enum AuthEndpoint {
    GENERATE_TOKEN("/Account/v1/GenerateToken");

    private final String path;
    AuthEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
