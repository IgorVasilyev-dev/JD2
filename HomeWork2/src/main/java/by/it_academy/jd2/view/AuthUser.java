package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.User;

import java.util.Objects;

public class AuthUser {

    private final UserService userService;
    private static AuthUser instance;

    public static AuthUser getInstance () {
        if(instance == null) {
            instance = new AuthUser();
        }
        return instance;
    }

    public AuthUser() {
        this.userService = UserService.getInstance();
    }

    public User checkAuthUser (String login, String password) {
        User user = this.userService.getUser(login);
        if (user == null) {
            return null;
        }
        if (!Objects.equals(user.getPassword(), password)) {
            return null;
        }
        return user;
    }
}
