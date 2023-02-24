package service;

import Enums.PathString;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseService {
    public static final Gson GSON = new GsonBuilder().create();

    public static Response getResponse(Method method, RequestSpecification requestSpecification, String bearerToken) {
        requestSpecification
                .headers("Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON)
                .baseUri(PathString.SITE_URL.getPath())
                .log().uri()
                .when()
                .get()
                .then()
                .extract()
                .response()
                .prettyPrint();
        return requestSpecification.request(method);
    }

    public static Response getResponse(Method method, RequestSpecification requestSpecification) {
        requestSpecification
                .baseUri(PathString.SITE_URL.getPath())
                .contentType(ContentType.JSON)
                .log().uri()
                .when()
                .get()
                .then()
                .extract()
                .response()
                .prettyPrint();
        return requestSpecification.request(method);
    }

    public static Response sendModel(Method method, String path, Object model) {
        RequestSpecification requestSpecification = given()
                .basePath(path)
                .body(GSON.toJson(model));
        return getResponse(method, requestSpecification);
    }

    public static Response sendModel(Method method, String path, Object model, String token) {
        RequestSpecification requestSpecification = given()
                .basePath(path)
                .body(GSON.toJson(model));
        return getResponse(method, requestSpecification, token);
    }

    public static Response sendModel(Method method, String path) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        return getResponse(method, requestSpecification);
    }

    public static void authResponse(String bearerToken) {
        RestAssured.given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type", "application/json");
    }

    public static Response sendModelWithQueryParam(Method method, String path, Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        map.forEach(requestSpecification::queryParam);
        return getResponse(method, requestSpecification);
    }
}
