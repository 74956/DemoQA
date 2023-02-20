package tests;

import Enums.PathString;
import Enums.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.BookModal;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ResponseService;

public class Auth {

    private ResponseService responseService = new ResponseService();
    private String userName = "Tati123";
    private String password = "GjuxD89Kms!";
    @Test
    public void authTest() {
        //Using the preemptive directive of basic auth to send credentials to the server
        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic(userName, password);
        Response res = httpRequest.get("https://demoqa.com/Account/v1/Authorized");
        ResponseBody body = res.body();
        //Converting the response body to string

    }

    @Test
    public void addBooks(){
        Response response = ResponseService.sendModel(Method.GET, String.valueOf(PathString.ALL_BOOKS), BookModal.class, token);
        Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
    }
}

