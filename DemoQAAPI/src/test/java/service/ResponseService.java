package service;

import Enums.PathString;
import ch.qos.logback.core.subst.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


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

    public static Response sendModel(Method method, String path, Object model, Token bearerToken) {
        RequestSpecification requestSpecification = given()
                .basePath(path)
                .body(GSON.toJson(model));
        return getResponse(method, requestSpecification, bearerToken);
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
}
