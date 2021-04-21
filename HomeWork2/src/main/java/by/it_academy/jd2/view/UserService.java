package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.storage.UsersStorage;

import java.util.Collection;

public class UserService {

    private final UsersStorage usersStorage;
    private static UserService instance;

    public static UserService getInstance () {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        this.usersStorage = UsersStorage.getInstance();
    }

    public void checkUser (User user) {
        this.formValidation(user);
        this.usersStorage.add(user);
    }

    private boolean emptyForm(String val) {
        return val == null || val.isEmpty();
    }

    private  void formValidation (User user) {
        String errorMessage = "";
        if(this.emptyForm(user.getLogin())) {
            errorMessage += "Пожалуйста заполните поле 'Логин' ";
        }
        if(this.emptyForm(user.getPassword())) {
            errorMessage += "Пожалуйста заполните поле 'Пароль' ";
        }
        if(this.emptyForm(user.getFio())) {
            errorMessage += "Пожалуйста заполните поле 'ФИО' ";
        }
        if(!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public User getUser (String login) {
        return this.usersStorage.getUser(login);
    }

    public Collection<User> getAll () {
        return this.usersStorage.getALL();
    }
}
