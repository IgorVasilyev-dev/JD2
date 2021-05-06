package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dao.hibernate.FlightHDao;
import by.it_academy.jd2.core.dao.hibernate.StorageService;
import by.it_academy.jd2.core.dto.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="FlightSelectServlet", urlPatterns = "/flight")
public class FlightSelectServlet extends HttpServlet {

    private  final StorageService store;
    private static final int TOTAL_LIST_VALUE = 25;

    public FlightSelectServlet () {
        this.store = StorageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.setAttribute("airList", store.getAirList());
        req.getRequestDispatcher("flight.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int n;

        HttpSession session = req.getSession();

        String depAir = store.getAirportCode(req.getParameter("departureAirport"));
        String scDep = req.getParameter("departureDate");
        String arrAir = store.getAirportCode(req.getParameter("arrivalAirport"));
        String scArr = req.getParameter("arrivalDate");

        try {
            IDao<Flight> flightHDao = new FlightHDao(depAir, scDep, arrAir, scArr);
            n = 1 + flightHDao.getCount() / TOTAL_LIST_VALUE;
            List<Flight> list = flightHDao.getRecords(0, TOTAL_LIST_VALUE);
            if (list.isEmpty()) {
                req.setAttribute("error", true);
                req.setAttribute("message", "По вашему запросу ничего не найдено");
            } else {
                store.transList(list);
                req.setAttribute("flightList", list);
            }
            session.setAttribute("flightDao", flightHDao);
            session.setAttribute("pageN", n);
            req.setAttribute("page", 1);
            req.getRequestDispatcher("flightList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("flight.jsp").forward(req, resp);
        }
    }
}
