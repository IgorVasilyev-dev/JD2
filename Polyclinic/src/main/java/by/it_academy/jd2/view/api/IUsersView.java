package by.it_academy.jd2.view.api;

import by.it_academy.jd2.model.User;

import java.util.List;

public interface IUsersView {
    List<User> getAll();
    User getById(String login);
    void addUser(User user);
    void updateUser(User provider, String login);
    void deleteUser(String login);

}
