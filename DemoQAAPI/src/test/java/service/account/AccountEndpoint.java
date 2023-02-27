package service.account;

public enum AccountEndpoint {

    ACCOUNT_AUTH("Account/v1/Authorized");

    private final String path;
    AccountEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
