package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.view.MessageService;
import by.it_academy.jd2.view.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "MessageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {

    private final MessageService messageService;
    private final UserService userService;

    public MessageServlet() {
        this.messageService = MessageService.getInstance();
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allUsers", userService.getAllLogin());
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пожалуйста выполните авторизацию");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        } else {
            String msg = req.getParameter("msg");
            String recipient = req.getParameter("recipient");
            String sender = user.getLogin();

            Message message = new Message();
            message.setSentFrom(sender);
            message.setSendText(msg);

            try {
                messageService.addMessage(recipient,message);
                req.setAttribute("allUsers", userService.getAllLogin());
                req.setAttribute("success", true);
            } catch (IllegalArgumentException | SecurityException | SQLException e) {
                req.setAttribute("error", true);
                req.setAttribute("message", e.getMessage());
            }
            req.getRequestDispatcher("message.jsp").forward(req, resp);
        }
    }
}
