package by.it_academy.jd2.core.dao.api;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    List<T> getRecords(int start, int total) throws SQLException;

    int getCount() throws SQLException;

}
