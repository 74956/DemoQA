package service.account;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.LoginViewModel;
import org.apache.hc.core5.http.HttpStatus;
import service.base.BaseEndpoint;

import static io.restassured.RestAssured.given;

public class AccountService {

    public static LoginViewModel generateModel(String userName, String password) {
        LoginViewModel loginModel = new LoginViewModel();
        loginModel.setUserName(userName);
        loginModel.setPassword(password);
        return loginModel;
    }

    public Response authorization(LoginViewModel loginViewModel) { //либо List<String> isbn
        String baseUrl = BaseEndpoint.SITE_URL.getPath();
        String url = baseUrl + AccountEndpoint.ACCOUNT_AUTH.getPath();
        return given()
                .when()
                .header("Content-Type",
                        ContentType.JSON)
                .body(loginViewModel)
                .post(url);
    }

    public void authorized(LoginViewModel loginViewModel) {
        authorization(loginViewModel)
                .then()
                .log().everything()
                .statusCode(HttpStatus.SC_OK);
    }
}
