package by.it_academy.jd2.core.dao.hibernate;

import by.it_academy.jd2.core.dao.JDBC.AirDao;
import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dto.Air;
import by.it_academy.jd2.core.dto.Flight;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.*;

public class StorageService {

    private static final HashMap<String,String> airport = new HashMap<>();
    private static List<Air> airList = new ArrayList<>();

    public static StorageService instance;

    /**
     * Получить экземпляр класса
     * @return instance
     */
    public static StorageService getInstance() {
        if(instance == null || airList == null) {
            addRows();
            return new StorageService();
        }
        return instance;
    }

    /**
     * метод добавляет записи в поле airList и airport
     */
    private static void addRows() {
            try {
                IDao<Air> airIDao = new AirDao();
                airList = airIDao.getRecords(0,104);
            } catch (PropertyVetoException | SQLException e) {
                e.printStackTrace();
            }
            for (Air e: airList) {
                airport.put(e.getAirport_name(),e.getAirport_code());
            }
    }

    /**
     * Получить код аэропорта по ключу
     * @param airportName ключ
     * @return код аэропорта
     */
    public String getAirportCode (String airportName) {
        return airport.get(airportName);
    }

    /**
     * Получить имя аэропорта по ключу
     * @param airportCode ключ
     * @return имя аэропорта
     */
    public String getAirportName (String airportCode) {
        String name = "";
        Optional<String> result = airport.entrySet()
                .stream()
                .filter(entry -> airportCode.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            name = result.get();
        }
        return name;
    }

    /**
     * получить значение поля airList
     * @return airList
     */
    public List<Air> getAirList() {
        return airList;
    }

    /**
     * Метод меняет значения в списке
     * @param flightList список
     */
    public void transList(List<Flight> flightList) {
        for (Flight e:flightList) {
            e.setDepartureAirport(getAirportName(e.getDepartureAirport()));
            e.setArrivalAirport(getAirportName(e.getArrivalAirport()));
        }
    }
}
