package service;

import object.User;

public class UserService {
    private static final String USER_NAME = "Tati";
    private static final String PASSWORD = "GjuxD89Kms!";

    public static User credentials(){
        return new User(USER_NAME, PASSWORD);
    }
}
