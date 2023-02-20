package model;

import ch.qos.logback.core.subst.Token;
import io.restassured.RestAssured;

public class AuthService {

    public static void authorization(Token token){
        RestAssured.given().header("Authorization", "bearer " + token).when().get("/search").
                then().assertThat().statusCode(200);
    }
}
