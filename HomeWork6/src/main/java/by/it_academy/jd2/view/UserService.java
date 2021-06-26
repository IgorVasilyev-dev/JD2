package by.it_academy.jd2.view;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.storage.api.IUsersRepository;
import by.it_academy.jd2.view.api.IUserService;

import java.util.HashSet;

public class UserService implements IUserService {

    private final IUsersRepository repository;
    static HashSet<String> allUsersLogin = new HashSet<>();

    public UserService(IUsersRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод проверяет объект user и добовляет его в repository
     * @param user объект класса User
     */
    @Override
    public void checkUser (User user) {
        this.formValidation(user);
        if (repository.findById(user.getLogin()).isPresent()) {
            throw new IllegalArgumentException("Этот логин уже занят");
        } else {
            allUsersLogin.add(user.getLogin());
            this.repository.save(user);
        }
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

    /**
     * метод проверки объекта user на пустые поля
     * @param user обект класса User
     */
    @Override
    public void formValidation (User user) {
        String errorMessage = "";
        if(this.emptyForm(user.getLogin())) {
            errorMessage += "Пожалуйста заполните поле 'Логин' ";
        }
        if(this.emptyForm(user.getPassword())) {
            errorMessage += "Пожалуйста заполните поле 'Пароль' ";
        }
        if(this.emptyForm(user.getFio())) {
            errorMessage += "Пожалуйста заполните поле 'ФИО' ";
        }
        if(!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Метод получает объект user из repository по ключу Login
     * @param login ключ
     * @return возвращает объект user
     */
    @Override
    public User getUser (String login) {
        return this.repository.getUserByLogin(login);
    }

    /**
     * Метод получает список allUsersLogin из repository
     * @return список allUsersLogin
     */
    @Override
    public HashSet<String> getAllLogin () {
        if(allUsersLogin == null || allUsersLogin.isEmpty()) {
            for (User user : repository.findAll()) {
                allUsersLogin.add(user.getLogin());
            }
            return allUsersLogin;
        }
       return allUsersLogin;
    }
}
