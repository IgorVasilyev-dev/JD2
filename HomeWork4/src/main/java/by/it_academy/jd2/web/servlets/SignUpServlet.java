package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.view.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {

    private final UserService userService;

    public SignUpServlet() {
        this.userService = UserService.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        String fio = req.getParameter("fio");
        String birthDay = req.getParameter("birthDay");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setBirthDay(birthDay);

        try {
            this.userService.checkUser(user);
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IllegalArgumentException | SQLException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
    }
}
