package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.storage.MessagesStorage;

import java.util.List;

public class MessageService {

    private static MessageService instance;
    private final MessagesStorage messagesStorage;

    public MessageService() {
        this.messagesStorage = MessagesStorage.getInstance();
    }

    /**
     * pattern singleton
     * @return new MessageService() если instance == null
     */
    public static MessageService getInstance () {
        if(instance == null) {
            instance = new MessageService();
        }
        return instance;
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
     * Метод добовляет message в messagesStorage
     * @param recipient получатель
     * @param message текст
     */
    public void addMessage(String recipient, Message message) {
        this.formValidation(message);
        this.messagesStorage.add(message,recipient);
    }

    /**
     * получает список по ключу user
     * @param user ключ
     * @return список message объекта user
     */
    public List<Message> getList (User user) {
        return this.messagesStorage.getList(user.getLogin());
    }

    /**
     * метод проверки объекта message на пустые поля
     * @param message обект класса Message
     */
    private  void formValidation (Message message) {
        String errorMessage = "";
        if(this.emptyForm(message.getSentFrom())) {
            errorMessage += "Пожалуйста укажите получателя ";
        }
        if(this.emptyForm(message.getSendText())) {
            errorMessage += "Нельзя отправить пустое сообщение ";
        }
        if(!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
