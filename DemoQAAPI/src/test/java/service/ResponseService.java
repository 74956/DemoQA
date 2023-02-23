package service;

import Enums.PathString;
import ch.qos.logback.core.subst.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.LoginViewModel;
import model.TokenViewModel;


import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseService {
    public static final Gson GSON = new GsonBuilder().create();

    public static Response getResponse(Method method, RequestSpecification requestSpecification, Token bearerToken) {
        requestSpecification
                .headers("Authorization",
                                "Bearer " + bearerToken,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
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
    public static Response sendModel(Method method, String path) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        return getResponse(method, requestSpecification);
    }

//    public static Response authResponse(Token bearerToken){
//        return given()
//                        .headers(
//                                "Authorization",
//                                "Bearer " + bearerToken,
//                                "Content-Type",
//                                ContentType.JSON,
//                                "Accept",
//                                ContentType.JSON)
//                        .when()
//                        .get(PathString.SITE_URL.getPath() + PathString.TOKEN.getPath())
//                        .then()
//                        .contentType(ContentType.JSON)
//                        .extract()
//                        .response();
//    }

    public static Response sendModelWithQueryParam(Method method, String path, Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        map.forEach(requestSpecification::queryParam);
        return getResponse(method, requestSpecification);
    }
}
