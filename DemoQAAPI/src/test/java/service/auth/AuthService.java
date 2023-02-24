package service.auth;

import io.restassured.response.Response;
import model.LoginViewModel;
import service.base.BaseEndpoint;
import service.base.BaseService;

public class AuthService extends BaseService {

    public Response generateToken(LoginViewModel loginViewModel){
        String url = AuthEndpoint.GENERATE_TOKEN.getPath();


    }
}
