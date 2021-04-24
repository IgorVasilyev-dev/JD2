package by.it_academy.jd2.core.dao.api;

import java.sql.SQLException;

public interface IDaoUser<T> {

    /**
     * Метод добовляет логин в коллекцию
     * @param login - логин
     */
    void addLogin (String login);

    /**
     * Метод добовляет объект t в БД
     * @param t - объект типа T
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void add(T t) throws SQLException;

    /**
     * Метод получает объект t из БД
     * @param login - ключ запроса
     * @return возвращает объет t типа T
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    T getUser(String login) throws SQLException;
}
