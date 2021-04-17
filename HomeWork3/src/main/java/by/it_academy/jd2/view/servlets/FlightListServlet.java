package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.dao.FlightDao;
import by.it_academy.jd2.core.dto.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightListServlet", urlPatterns = "/flightList")
public class FlightListServlet extends HttpServlet {

    private final static int TOTAL_LIST_VALUE = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int pageId, start;

        if (req.getParameter("page") == null || req.getParameter("page").isEmpty()) {
            pageId = 1;
        } else {
            pageId = Integer.parseInt(req.getParameter("page"));
        }

        if (pageId <= 1) {
            start = 0;
            pageId = 1;
        } else {
            start = pageId - 1;
            start = start * TOTAL_LIST_VALUE;
        }

        FlightDao flightDao = (FlightDao) session.getAttribute("flightDao");
        List<Flight> list = flightDao.getRecords(start, TOTAL_LIST_VALUE);

        if (list.isEmpty()) {
            req.setAttribute("error", true);
            req.setAttribute("message", "По вашему запросу ничего не найдено");
        } else {
            req.setAttribute("flightList", list);
        }

        req.setAttribute("page", pageId);
        req.getRequestDispatcher("flightList.jsp").forward(req, resp);
    }

}
