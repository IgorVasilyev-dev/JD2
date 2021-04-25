package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.storage.UsersStorage;

import java.util.HashSet;

public class UserService {

    private final UsersStorage usersStorage;
    private static UserService instance;

    /**
     * pattern singleton
     * @return new UserService() елсли instance == null
     */
    public static UserService getInstance () {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        this.usersStorage = UsersStorage.getInstance();
    }

    /**
     * Метод проверяет объект user и добовляет его в userStorage
     * @param user объект класса User
     */
    public void checkUser (User user) {
        this.formValidation(user);
        if (UsersStorage.getAllLogin().contains(user.getLogin())) {
            throw new IllegalArgumentException("Этот логин уже занят");
        } else {
            this.usersStorage.add(user);
        }
    }

    /**
     * Метод проверки значений на null or empty
     * @param val передоваемый параметр
     * @return возвращает true если val не null or empty
     */
    private boolean emptyForm(String val) {
        return val == null || val.isEmpty();
    }

    /**
     * метод проверки объекта user на пустые поля
     * @param user обект класса User
     */
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

    /**
     * Метод получает объект user из usersStorage по ключу Login
     * @param login ключ
     * @return возвращает объект user
     */
    public User getUser (String login) {
        return this.usersStorage.getUser(login);
    }

    /**
     * Метод получает список usersLogin из usersStorage
     * @return список usersLogin
     */
    public HashSet<String> getAllLogin () {
       return UsersStorage.getAllLogin();
    }
}
