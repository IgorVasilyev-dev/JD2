package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, String> {

    List<Message> findAllByRecipient(String recipient);
}
