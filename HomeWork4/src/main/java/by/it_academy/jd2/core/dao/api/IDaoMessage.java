package by.it_academy.jd2.core.dao.api;

import java.sql.SQLException;
import java.util.List;

public interface IDaoMessage<T> {

    /**
     * Метод добовляет объект в БД
     * @param t объект типа T
     * @param login параметр String
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    void add(T t, String login) throws SQLException;

    /**
     * Метод получучает записи из БД
     * @param login ключ запроса
     * @return возвращает список
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    List<T> getList(String login) throws SQLException;

}
