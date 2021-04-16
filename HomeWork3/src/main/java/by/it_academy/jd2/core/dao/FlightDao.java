package by.it_academy.jd2.core.dao;

import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.dao.api.IDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IDao<Flight> {

    private static DataSource dataSource;
    private final String depAir;
    private final String arrAir;
    private final String scDep;
    private final String scArr;

    public FlightDao(String depAir, String scDep, String arrAir, String scArr) throws PropertyVetoException {

        if (!scDep.isEmpty()) {
            scDep = " AND DATE(scheduled_departure) = '" + scDep + "'";
        }
        if (!scArr.isEmpty()) {
            scArr = " AND DATE(scheduled_arrival) = '"+ scArr + "'";
        }

        dataSource = DataSourceCreator.getInstance();
        this.depAir = depAir;
        this.scDep = scDep;
        this.arrAir = arrAir;
        this.scArr = scArr;
    }

    @SuppressWarnings("SqlResolve")
    @Override
    public List<Flight> getRecords(int start, int total) {
        List<Flight> list = new ArrayList<>();
        try (Connection con = dataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT scheduled_departure, departure_airport, scheduled_arrival, arrival_airport FROM\n" +
                            "(SELECT bf.flight_id, \n" +
                            "ba.airport_name ->> 'ru' AS departure_airport,\n" +
                            "bf.scheduled_departure\n" +
                            "FROM bookings.airports_data ba,\n" +
                            "bookings.flights bf\n" +
                            "WHERE (ba.airport_code = bf.departure_airport)) AS departure \n" +
                            "INNER JOIN \n" +
                            "(SELECT bf.flight_id,\n" +
                            "ba.airport_name ->> 'ru' AS arrival_airport,\n" +
                            "bf.scheduled_arrival\n" +
                            "FROM bookings.airports_data ba,\n" +
                            "bookings.flights bf\n" +
                            "WHERE (ba.airport_code = bf.arrival_airport)) AS arrival\n" +
                            "ON departure.flight_id = arrival.flight_id\n" +
                            "WHERE departure_airport = '" + depAir + "'" + scDep +
                            "AND arrival_airport = '" + arrAir + "'" + scArr +
                            " LIMIT " + total + " OFFSET " + start +";"
            );

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight e = new Flight();
                e.setDepartureDate(rs.getString(1));
                e.setDepartureAirport(rs.getString(2));
                e.setArrivalDate(rs.getString(3));
                e.setArrivalAirport(rs.getString(4));
                list.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @SuppressWarnings("SqlResolve")
    @Override
    public int getCount() {
        int count = 0;
        try (Connection con = dataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM\n" +
                            "(SELECT bf.flight_id, \n" +
                            "ba.airport_name ->> 'ru' AS departure_airport,\n" +
                            "bf.scheduled_departure\n" +
                            "FROM bookings.airports_data ba,\n" +
                            "bookings.flights bf\n" +
                            "WHERE (ba.airport_code = bf.departure_airport)) AS departure \n" +
                            "INNER JOIN \n" +
                            "(SELECT bf.flight_id,\n" +
                            "ba.airport_name ->> 'ru' AS arrival_airport,\n" +
                            "bf.scheduled_arrival\n" +
                            "FROM bookings.airports_data ba,\n" +
                            "bookings.flights bf\n" +
                            "WHERE (ba.airport_code = bf.arrival_airport)) AS arrival\n" +
                            "ON (departure.flight_id = arrival.flight_id)\n" +
                            "WHERE departure_airport = '" + depAir + "'" + scDep +
                            "AND arrival_airport = '" + arrAir + "'" + scArr + ";"
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
