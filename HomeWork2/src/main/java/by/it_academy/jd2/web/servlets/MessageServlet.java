package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.view.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MessageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {

    private final UserService userService;

    public MessageServlet() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        for (User e: userService.getAll()) {
            list.add(e.getLogin());
        }
        req.setAttribute("allUsers", list);
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            throw new SecurityException("Ошибка безопасности");
        }

        String message = req.getParameter("msg");
        String recipient = req.getParameter("recipient");
        String sender = user.getLogin();

        try {

            System.out.println("над этим еще надо поработать");
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
        }
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }
}
