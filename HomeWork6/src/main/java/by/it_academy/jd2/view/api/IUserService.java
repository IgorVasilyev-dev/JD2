package by.it_academy.jd2.view.api;

import by.it_academy.jd2.model.User;

import java.util.HashSet;

public interface IUserService {

    void checkUser (User user);
    boolean emptyForm(String val);
    void formValidation (User user);
    User getUser (String login);
    HashSet<String> getAllLogin ();

}
