package by.it_academy.jd2.service.api;

import by.it_academy.jd2.model.User;

public interface IAuthUser {

    void signUp(User user);

    User signIn (String login, String password);

}
