package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<User, String> {

    User getUserByLogin(String login);

}
