package service.base;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    public static Response getResponse(Method method, RequestSpecification requestSpecification, String bearerToken) {
        requestSpecification
                .headers("Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON)
                .baseUri(BaseEndpoint.SITE_URL.getPath())
                .log().uri()
                .when()
                .get()
                .then()
                .extract()
                .response()
                .prettyPrint();
        return requestSpecification.request(method);
    }


}
