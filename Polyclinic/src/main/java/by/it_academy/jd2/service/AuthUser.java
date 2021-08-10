package by.it_academy.jd2.service;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.service.api.IAuthUser;
import by.it_academy.jd2.service.api.IUserService;

import java.util.Objects;

public class AuthUser implements IAuthUser {

    private final IUserService userService;

    public AuthUser(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void signUp(User user) {
        userService.checkUser(user);
    }

    @Override
    public User signIn(String login, String password) {
            User user = this.userService.findByLogin(login);
            if (user == null) {
                return null;
            }
            if (!Objects.equals(user.getPassword(), password)) {
                return null;
            }
            return user;
    }
}
