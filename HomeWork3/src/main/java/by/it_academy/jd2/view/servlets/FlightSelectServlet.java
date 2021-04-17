package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.dto.Air;
import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dao.AirDao;
import by.it_academy.jd2.core.dao.FlightDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name ="FlightSelectServlet", urlPatterns = "/flight")
public class FlightSelectServlet extends HttpServlet {

    private static final int TOTAL_LIST_VALUE = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("airList") == null) {
            try {
                IDao<Air> airDao = new AirDao();
                List<Air> airList = airDao.getRecords(0, airDao.getCount());
                session.setAttribute("airList", airList);
            } catch (PropertyVetoException | SQLException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("flight.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int n;

        HttpSession session = req.getSession();

        String depAir = req.getParameter("departureAirport");
        String scDep = req.getParameter("departureDate");
        String arrAir = req.getParameter("arrivalAirport");
        String scArr = req.getParameter("arrivalDate");

        try {
            IDao<Flight> flightDao = new FlightDao(depAir, scDep, arrAir, scArr);
            n = 1 + flightDao.getCount() / TOTAL_LIST_VALUE;
            List<Flight> list = flightDao.getRecords(0, TOTAL_LIST_VALUE);
            if (list.isEmpty()) {
                req.setAttribute("error", true);
                req.setAttribute("message", "По вашему запросу ничего не найдено");
            } else {
                req.setAttribute("flightList", list);
            }
            session.setAttribute("flightDao", flightDao);
            session.setAttribute("pageN", n);
            req.setAttribute("page", 1);
            req.getRequestDispatcher("flightList.jsp").forward(req, resp);
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("flight.jsp").forward(req, resp);
        }
    }
}
