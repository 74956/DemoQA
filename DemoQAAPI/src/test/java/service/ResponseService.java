package service;

import Util.PathString;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseService {
    public static Response getResponse(Method method, RequestSpecification requestSpecification) {
        requestSpecification
                .baseUri(PathString.URL.getPath())
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri().log().headers();
        return requestSpecification.request(method);
    }

    public static Response getModelResponse(String path) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        return getResponse(Method.GET, requestSpecification);
    }

    public static Response getModelWithQueryParam(String path, Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        map.forEach(requestSpecification::queryParam);
        return getResponse(Method.GET, requestSpecification);
    }
}
