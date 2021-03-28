package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет для печати данных из Model
 */
@WebServlet(name = "PrintPerson", urlPatterns = "/printPerson")
public class PrintPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        Model model = Model.getInstance();
        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter()) {
            for (String person: model.list()) {
                writer.print("<h2>" + person + "</h2>");
            }
        }
    }
}
