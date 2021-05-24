package by.it_academy.jd2.core.dao.hibernate;

import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dto.Flight;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class FlightHDao implements IDao<Flight>{

    private final Session session;
    private final String depAir;
    private final String arrAir;
    private final String scDep;
    private final String scArr;

    /**
     * конструктор с параметрами, по умолчанию получает сессию из HibernateCreator
     * @param depAir аэропорт оправления
     * @param scDep дата отвправления
     * @param arrAir аэропорт прибытия
     * @param scArr дата прибытия
     */
    public FlightHDao(String depAir, String scDep, String arrAir, String scArr) {

        if (!scDep.isEmpty()) {
            scDep = " AND DATE(scheduled_departure) = '" + scDep + "'";
        }
        if (!scArr.isEmpty()) {
            scArr = " AND DATE(scheduled_arrival) = '"+ scArr + "'";
        }

        this.session = HibernateCreator.getInstance().openSession();
        this.depAir = depAir;
        this.scDep = scDep;
        this.arrAir = arrAir;
        this.scArr = scArr;
    }

    /**
     * Получить записи из БД
     * @param start номер начальной записи
     * @param total количество записей
     * @return список
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    @Override
    public List<Flight> getRecords(int start, int total) throws SQLException {
        Query<Flight> query  = session.createQuery("FROM flights \n" +
                "where departureAirport = :departureAirport \n" + scDep +
                "AND arrivalAirport =:arrivalAirport \n" + scArr, Flight.class)
                .setParameter("departureAirport", depAir)
                .setParameter("arrivalAirport",arrAir)
                .setFirstResult(start)
                .setMaxResults(total);
        return query.list();
    }

    /**
     * Получить количество записей из БД
     * @return количесвто записей
     */
    @Override
    public int getCount() {
        return session.createQuery("FROM flights \n" +
                "where departureAirport = :departureAirport \n" + scDep +
                "AND arrivalAirport =:arrivalAirport \n" + scArr, Flight.class)
                .setParameter("departureAirport", depAir)
                .setParameter("arrivalAirport",arrAir).list().size();
    }

}
