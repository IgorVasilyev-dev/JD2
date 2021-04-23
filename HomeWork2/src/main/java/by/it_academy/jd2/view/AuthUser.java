package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.User;

import java.util.Objects;

public class AuthUser {

    private final UserService userService;
    private static AuthUser instance;

    /**
     * pattern singleton
     * @return new new AuthUser() если instance == null
     */
    public static AuthUser getInstance () {
        if(instance == null) {
            instance = new AuthUser();
        }
        return instance;
    }

    public AuthUser() {
        this.userService = UserService.getInstance();
    }

    /**
     * Метод проверки параметров login и password объекта user из коллекции c параметрам login и password
     * @param login параметр
     * @param password параметр
     * @return возвращает объект user если параметры эдентичны, иначе - null
     */
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
