package by.it_academy.jd2.view;

import by.it_academy.jd2.model.Message;
import by.it_academy.jd2.model.User;
import by.it_academy.jd2.storage.api.IMessageRepository;
import by.it_academy.jd2.view.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {

    private final IMessageRepository repository;

    public MessageService(IMessageRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод проверки значений на null or empty
     * @param val передоваемый параметр
     * @return возвращает true если val не null or empty
     */
    @Override
    public boolean emptyForm(String val) {
        return val == null || val.isEmpty();
    }

    @Override
    public void addMessage(Message message) {
        this.formValidation(message);
        this.repository.save(message);
    }

    /**
     * получает список по ключу user
     * @param user ключ
     * @return список message объекта user
     */
    @Override
    public List<Message> getList (User user) {
        return this.repository.findAllByRecipient(user.getLogin());
    }

    /**
     * метод проверки объекта message на пустые поля
     * @param message обект класса Message
     */
    @Override
    public void formValidation(Message message) {
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
