package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dto.User;

import java.util.ArrayList;
import java.util.List;

public class MessagesStorage {

    private static MessagesStorage instance;
    private final List<String> message;

    public static MessagesStorage getInstance() {
        if (instance == null) {
            instance = new MessagesStorage();
        }
        return instance;
    }

    private MessagesStorage() {
        message = new ArrayList<>();
    }

    public void add(User user, String messages) {
        message.add(user.getLogin() + ": " + messages);
    }

    public List<String> list() {
        return message;
    }
}
