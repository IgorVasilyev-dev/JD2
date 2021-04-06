package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UsersStorage {

    private final Map<String, User> users = new HashMap<>();
    private static UsersStorage instance;

    public static UsersStorage getInstance() {
        if (instance == null) {
            instance = new UsersStorage();
        }
        return instance;
    }

    private UsersStorage() {}

    public User getUser(String login) {
        return this.users.get(login);
    }

    public void add(User user) {
        this.users.put(user.getLogin(), user);
    }
}
