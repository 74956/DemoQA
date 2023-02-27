package service.base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.TokenViewModel;

import static io.restassured.RestAssured.given;

public class BaseService {

    private final TokenViewModel token;

    public BaseService(TokenViewModel token) {
        this.token = token;
    }

    public RequestSpecification getAuthorizedRequest() {

        return given().header(
                "Authorization",
                        "Bearer " + token.getToken(),
                        "Content-Type",
                        ContentType.JSON);
    }
}
