package by.it_academy.jd2.controller.web.servlets;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.view.api.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "user")
@RequestMapping(value = "/chat" )
public class ChatServlet {

    private final IMessageService messageService;

    public ChatServlet(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    protected String getAllMessages(Model model){
        User user = (User) model.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Пожалуйста выполните авторизацию");
            return "/views/signIn.jsp";
        } else {
            model.addAttribute("allMessage", messageService.getList(user));
            return "/views/chat.jsp";
        }
    }
}
