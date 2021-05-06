package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dao.hibernate.AirHDao;
import by.it_academy.jd2.core.dto.Air;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private static final int TOTAL_LIST_VALUE = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int n, pageId, start;

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

        try {
            if(session.getAttribute("airDao") == null) {
                IDao<Air> airHDao = new AirHDao();
                n = 1 + airHDao.getCount() / TOTAL_LIST_VALUE;
                session.setAttribute("airDao",airHDao);
                session.setAttribute("pageN",n);
            }
            AirHDao airHDao = (AirHDao) session.getAttribute("airDao");
            List<Air> list = airHDao.getRecords(start, TOTAL_LIST_VALUE);
            req.setAttribute("airList", list);
            req.setAttribute("page", pageId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("air.jsp").forward(req, resp);
    }
}
