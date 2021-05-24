package by.it_academy.jd2.core.dao;

import by.it_academy.jd2.core.dto.Air;
import by.it_academy.jd2.core.dao.api.IDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirDao implements IDao<Air> {

    private static DataSource dataSource;

    /**
     * конструктор без параметров, по умолчанию получает dataSource из DataSourceCreator
     * @throws PropertyVetoException исключение возникате при недопустимом значении dataSource
     */
    public AirDao() throws PropertyVetoException {
         dataSource = DataSourceCreator.getInstance();
    }

    /**
     * Получить записи из БД
     * @param start параметр получения начальной записи
     * @param total количесвто получаемых записей
     * @return список
     */
    @Override
    public  List<Air> getRecords(int start, int total) {
        List<Air> list = new ArrayList<>();
        try (Connection con = dataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT ml.airport_code,\n" +
                            "   ml.airport_name ->> 'ru' AS airport_name,\n" +
                            "   ml.city ->> 'ru' AS city,\n" +
                            "   ml.coordinates,\n" +
                            "   ml.timezone\n" +
                            "   FROM bookings.airports_data ml ORDER BY city LIMIT " + total + " OFFSET " + start);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Air e = new Air();
                e.setAirport_code(rs.getString(1));
                e.setAirport_name(rs.getString(2));
                e.setCity(rs.getString(3));
                e.setCoordinates(rs.getString(4));
                e.setTimezone(rs.getString(5));
                list.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * Получить количество записей
     * @return количество записей
     */
    @Override
    public int getCount() {
        int count = 0;
        try (Connection con = dataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT  COUNT(*) FROM (SELECT ml.airport_code,\n" +
                            "   ml.airport_name ->> 'ru' AS airport_name,\n" +
                            "   ml.city ->> 'ru' AS city,\n" +
                            "   ml.coordinates,\n" +
                            "   ml.timezone\n" +
                            "   FROM bookings.airports_data ml ORDER BY city) AS count"
            );

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
