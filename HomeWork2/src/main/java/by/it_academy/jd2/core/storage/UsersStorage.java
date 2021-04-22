package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dto.User;

import java.util.*;

public class UsersStorage {

    private final Map<String, User> users = new HashMap<>();
    private final HashSet<String> usersLogin = new HashSet<>();
    private static UsersStorage instance;

    /**
     * pattern singleton
     * @return new new UsersStorage() если instance == null
     */
    public static UsersStorage getInstance() {
        if (instance == null) {
            instance = new UsersStorage();
        }
        return instance;
    }

    private UsersStorage() {}

    /**
     * Метод получает объект user из коллекции users по ключу login
     * @param login ключ
     * @return объект user
     */
    public User getUser(String login) {
        return this.users.get(login);
    }

    /**
     * Метод добавляет объект user в коллекцию users, если объект уже есть в коллекции, то создается IllegalArgumentException
     * @param user объект типа User
     */
    public void add(User user) {
        if (this.users.containsKey(user.getLogin())) {
            throw new IllegalArgumentException("Пользователь с таким именем уже существует");
    }
        this.users.put(user.getLogin(), user);
        this.usersLogin.add(user.getLogin());
    }

    /**
     * Получить всю коллекции users
     * @return занчения коллекции users
     */
    public Collection<User> getALL () {
        return this.users.values();
    }

    public HashSet<String> getAllLogin () {
        return usersLogin;
    }
}
