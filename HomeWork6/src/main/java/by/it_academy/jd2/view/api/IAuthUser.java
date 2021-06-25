package by.it_academy.jd2.view.api;

import by.it_academy.jd2.model.User;

public interface IAuthUser {

    User checkAuthUser(String login, String password);

}
