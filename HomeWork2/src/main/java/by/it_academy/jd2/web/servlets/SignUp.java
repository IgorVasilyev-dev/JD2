package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() + "/singUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fio = req.getParameter("fio");
        String birthDay = req.getParameter("birthDay");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setBirthDay(birthDay);
        resp.sendRedirect(req.getContextPath() + "/signIn");
    }

}
