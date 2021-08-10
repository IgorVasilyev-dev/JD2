package by.it_academy.jd2.view;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.storage.api.IUsersRepository;
import by.it_academy.jd2.utils.CopyProperties;
import by.it_academy.jd2.view.api.IUsersView;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UsersView implements IUsersView {

    private final IUsersRepository repository;

    public UsersView(IUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }


    @Override
    public User getById(String login) {
      return repository.getUserByLogin(login);
    }

    @Override
    @Transactional()
    public void addUser(User user) {
        repository.save(CopyProperties.insertAllProperties(user, new User()));
    }

    @Override
    @Transactional()
    public void updateUser(User provider, String login) {
        if((repository.getUserByLogin(login)) != null) {
            repository.save(CopyProperties.insertAllProperties(provider, repository.getUserByLogin(login)));
        }
    }

    @Override
    public void deleteUser(String login) {
        repository.deleteById(login);
    }
}
