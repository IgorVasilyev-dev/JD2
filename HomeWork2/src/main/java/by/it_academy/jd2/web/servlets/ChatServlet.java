package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.storage.MessagesStorage;
import by.it_academy.jd2.view.MessageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ChatServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {

    private final MessageService messageService;

    public ChatServlet() {
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Пожалуйста выполните авторизацию");
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        } else {
            req.setAttribute("allMessage", messageService.getList(user));
            req.getRequestDispatcher("chat.jsp").forward(req, resp);
        }
    }
}
