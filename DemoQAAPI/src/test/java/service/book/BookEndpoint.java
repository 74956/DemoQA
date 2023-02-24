package service.book;

import io.restassured.http.Method;


public enum BookEndpoint {

    ALL_BOOKS("/BookStore/v1/Books", Method.GET),

    BOOKS("/BookStore/v1/Books", Method.POST);

    private final String url;
    private final Method method;

    public BookEndpoint(String url, Method method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public Method getMethod() {
        return method;
    }
}
