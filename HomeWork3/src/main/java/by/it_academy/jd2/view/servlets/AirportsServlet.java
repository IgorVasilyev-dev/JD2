package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.dto.Air;
import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dao.AirDao;
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
                IDao<Air> airDao = new AirDao();
                n = 1 + airDao.getCount() / TOTAL_LIST_VALUE;
                session.setAttribute("airDao",airDao);
                session.setAttribute("pageN",n);
            }
            AirDao airDao = (AirDao) session.getAttribute("airDao");
            List<Air> list = airDao.getRecords(start, TOTAL_LIST_VALUE);
            req.setAttribute("airList", list);
            req.setAttribute("page", pageId);
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("air.jsp").forward(req, resp);
    }
}
