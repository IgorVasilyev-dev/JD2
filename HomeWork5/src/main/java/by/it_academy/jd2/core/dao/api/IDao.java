package by.it_academy.jd2.core.dao.api;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    /**
     * Метод получучает записи из БД
     * @param start номер начальной записи
     * @param total количество записей
     * @return возвращает список
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    List<T> getRecords(int start, int total) throws SQLException;

    /**
     * получить количетсво записей
     * @return количество записей
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    int getCount() throws SQLException;

}
