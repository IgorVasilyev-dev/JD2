package by.it_academy.jd2.view.servlets;

import by.it_academy.jd2.core.Air;
import by.it_academy.jd2.core.api.IDao;
import by.it_academy.jd2.core.dao.AirDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int n;
        String spageid;
        int total = 25;
        int pageid;
        spageid = req.getParameter("page");
        pageid = Integer.parseInt(spageid);

        if (pageid < 1) {
            pageid = 1;
        } else if (pageid > 1) {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
        try {
            IDao<Air> airDao = new AirDao();
            List<Air> list = airDao.getRecords(pageid, total);
            n = 1 + airDao.getCount() / total;
            req.setAttribute("airList", list);
            req.setAttribute("pageN", n);
            req.setAttribute("page", spageid);
        } catch (PropertyVetoException | SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("air.jsp").forward(req, resp);
    }
}
