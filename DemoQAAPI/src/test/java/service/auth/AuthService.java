package service.auth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.LoginViewModel;
import model.TokenViewModel;
import org.apache.hc.core5.http.HttpStatus;
import service.base.BaseEndpoint;


public class AuthService {

    private RequestSpecification requestSpecification;
    private RequestSpecification requestSpec;

    public AuthService() {
        this.requestSpecification = getRequestSpecification();
    }

    public RequestSpecification getRequestSpecification(){
        String baseUrl = BaseEndpoint.SITE_URL.getPath();
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON);
        requestSpec = builder.build();
        return requestSpec;
    }

    public Response generateToken(LoginViewModel loginViewModel) {
        String url = AuthEndpoint.GENERATE_TOKEN.getPath();
        return RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .body(loginViewModel)
                .post(url);
    }

    public TokenViewModel getToken(LoginViewModel loginViewModel) {
        return generateToken(loginViewModel)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .as(TokenViewModel.class);
    }
}
