package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dao.DataSourceCreator;
import by.it_academy.jd2.core.dao.api.IDaoUser;
import by.it_academy.jd2.core.dto.User;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class UsersStorage implements IDaoUser<User>{

    private static Connection connection;
    private static HashSet<String> usersLogin;
    private static UsersStorage instance;

    /**
     * pattern singleton
     * при первом вызове получаем connection и коллекции usersLogin
     * @return new UsersStorage() если instance == null
     */
    public static UsersStorage getInstance() {
        if (instance == null) {
            try {
                DataSource dataSource = DataSourceCreator.getInstance();
                connection = dataSource.getConnection();
            } catch (PropertyVetoException | SQLException e) {
                e.printStackTrace();
            }
            instance = new UsersStorage();
            usersLogin = getAllLogin();
        }
        return instance;
    }

    /**
     * Получаем коллекцию значении login из БД при инициализации класса
     * полчуем коллекцию из БД, если коллекция usersLogin == null
     * @return коллекцию usersLogin
     */
    public static HashSet<String> getAllLogin () {
        if (usersLogin == null) {
            usersLogin = new HashSet<>();
            String sql = "SELECT login From chat.user ;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    usersLogin.add(rs.getString(1));
                }
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return usersLogin;
    }

    /**
     * Метод добовляет логин в коллекцию usersLogin
     * @param login - логин
     */
    @Override
    public  void addLogin (String login) {
        usersLogin.add(login);
    }


    /**
     * Метод получает объект user из БД
     * @param login - ключ запроса
     * @return возвращает объект класса User
     */
    @Override
    public User getUser(String login) {
        User user = new User();
        String sql = "SELECT login, password, fio, birthday \n" +
                "From chat.user WHERE login = '" + login + "'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setLogin(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setFio(rs.getString(3));
                user.setBirthDay(rs.getString(4));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Метод добовляет объект user в БД, а также значение login объекта user в коллекцию usersLogin
     * @param user объект класса User
     */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO chat.user (login, password, fio, birthday) \n" +
                "values (?,?,?,?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFio());
            ps.setString(4, user.getBirthDay());
            ps.executeUpdate();
            addLogin(user.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
