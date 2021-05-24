package by.it_academy.jd2.core.dao.api;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    /**
     * Получить записи из БД
     * @param start параметр получения начальной записи
     * @param total количесвто получаемых записей
     * @return возвращает список
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    List<T> getRecords(int start, int total) throws SQLException;

    /**
     * Получить количество записей
     * @return возвращает количесво записей
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    int getCount() throws SQLException;

}
