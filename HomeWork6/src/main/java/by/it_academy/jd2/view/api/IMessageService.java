package by.it_academy.jd2.view.api;

import by.it_academy.jd2.model.Message;
import by.it_academy.jd2.model.User;

import java.util.List;

public interface IMessageService {

    boolean emptyForm(String val);
    void addMessage(Message message);
    List<Message> getList (User user);
    void formValidation (Message message);

}
