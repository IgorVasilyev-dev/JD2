package by.it_academy.jd2.service.api;

import by.it_academy.jd2.model.User;

public interface IUserService {

    boolean emptyForm(String val);

    void checkUser (User user);

    User findByLogin(String login);

    void addUser(User user);

    void formValidation (User user);

}
