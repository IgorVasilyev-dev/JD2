package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.storage.UsersStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
public class SignUp extends HttpServlet {

    private final UsersStorage usersStorage;

    public SignUp () {
        this.usersStorage = UsersStorage.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fio = req.getParameter("fio");
        String birthDay = req.getParameter("birthDay");

        if(usersStorage.getUser(login) == null) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setFio(fio);
            user.setBirthDay(birthDay);
            usersStorage.add(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("error", true);
            req.setAttribute("errorMessage", "Имя пользователя уже занято");
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
    }
}
