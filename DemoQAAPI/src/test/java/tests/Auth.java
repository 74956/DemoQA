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
    @Test
    public void authTest() {
        //Using the preemptive directive of basic auth to send credentials to the server
        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("Tati123", "GjuxD89Kms!");
        Response res = httpRequest.get("https://demoqa.com/Account/v1/Authorized");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- " + rbdy);
    }

    @Test
    public void addBooks(){
        Response response = ResponseService.sendModel(Method.GET, String.valueOf(PathString.ALL_BOOKS), BookModal.class);
        Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
    }
}

