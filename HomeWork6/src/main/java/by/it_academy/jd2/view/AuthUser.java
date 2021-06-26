package by.it_academy.jd2.view;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.view.api.IAuthUser;
import by.it_academy.jd2.view.api.IUserService;

import java.util.Objects;

public class AuthUser implements IAuthUser {

    private final IUserService userService;

    public AuthUser(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Метод двойной проверки, если login есть в коллекции HasSet то получаем объект из БД, иначе возвращаем null
     * Проверяем login и password объекта user полученного из БД c параметрам login и password
     * @param login параметр
     * @param password параметр
     * @return возвращает объект user если параметры эдентичны, иначе - null
     */
    @Override
    public User checkAuthUser (String login, String password) {
        if(this.userService.getAllLogin().contains(login)) {
            User user = this.userService.getUser(login);
            if (user == null) {
                return null;
            }
            if (!Objects.equals(user.getPassword(), password)) {
                return null;
            }
            return user;
        }
        return null;
    }
}
