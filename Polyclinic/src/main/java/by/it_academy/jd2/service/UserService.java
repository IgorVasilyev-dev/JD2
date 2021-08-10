package by.it_academy.jd2.service;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.view.api.IUsersView;

public class UserService  implements IUserService {

    private final IUsersView usersView;

    public UserService(IUsersView usersView) {
        this.usersView = usersView;
    }

    @Override
    public boolean emptyForm(String val) {
        return val == null || val.isEmpty();
    }

    @Override
    public void checkUser (User user) {
        this.formValidation(user);
        if (usersView.getById(user.getLogin()) != null) {
            throw new IllegalArgumentException("Этот логин уже занят");
        } else {
            this.usersView.addUser(user);
        }
    }

    @Override
    public void formValidation (User user) {
        String errorMessage = "";
        if(this.emptyForm(user.getLogin())) {
            errorMessage += "Пожалуйста заполните поле 'Логин' ";
        }
        if(this.emptyForm(user.getPassword())) {
            errorMessage += "Пожалуйста заполните поле 'Пароль' ";
        }
        if(this.emptyForm(user.getEmail())) {
            errorMessage += "Пожалуйста заполните поле 'email' ";
        }
        if(this.emptyForm(user.getTel())) {
            errorMessage += "Пожалуйста заполните поле 'Tel' ";
        }
        if(!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public User findByLogin(String login) {
        return this.usersView.getById(login);
    }

    @Override
    public void addUser(User user) {
        this.usersView.addUser(user);
    }

}
