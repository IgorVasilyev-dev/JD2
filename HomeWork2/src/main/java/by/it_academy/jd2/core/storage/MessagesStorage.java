package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dto.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesStorage {

    private static final Map<String, List<Message>> chat = new HashMap<>();
    private static MessagesStorage instance;

    /**
     * singleton pattern
     * @return new MessagesStorage() если instance == null
     */
    public static MessagesStorage getInstance() {
        if (instance == null) {
            instance = new MessagesStorage();
        }
        return instance;
    }

    /**
     * получаем список List<Message> из chat по ключу login
     * @param login ключ
     * @return List<Message>
     */
    public List<Message> getList(String login) {
        return chat.get(login);
    }

    /**
     * метод добовляет message в List<Message> полученный из chat по ключу login, если списка не сущесвует -
     * созает новый список и добовляет его в chat с ключом login
     * @param login ключ
     * @param message объект типа Message
     */
    public void addMessages(String login, Message message) {
        List<Message> msg;
        if (!chat.containsKey(login)) {
            msg = new ArrayList<>();
            chat.put(login,msg);
        } else {
            msg = chat.get(login);
        }
        msg.add(message);
    }

}
