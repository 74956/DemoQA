package Enums;

public enum StatusCode {

    OK(200),
    NOT_FOUND(404),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400);

    private final int code;

    public int getCode() {
        return code;
    }

    StatusCode(int code) {
        this.code = code;
    }
}
