package by.it_academy.jd2.controller.web.servlets;

import by.it_academy.jd2.model.Message;
import by.it_academy.jd2.model.User;
import by.it_academy.jd2.view.api.IMessageService;
import by.it_academy.jd2.view.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value = "user")
@RequestMapping(value = "/message")
public class MessageServlet {

    private final IMessageService messageService;
    private final IUserService userService;

    public MessageServlet(IMessageService messageService, IUserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    protected String getAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllLogin());
        return "/views/message.jsp";
    }

    @PostMapping
    protected String addMessage(@RequestParam (name = "recipient") String recipient,
                            @RequestParam(name = "msg" ) String msg,
                            Model model) {

        User user = (User) model.getAttribute("user");

        if (user == null) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Пожалуйста выполните авторизацию");
            return "/views/signIn.jsp";
        } else {
            Message message = new Message();
            message.setSentFrom(user.getLogin());
            message.setSendText(msg);
            message.setRecipient(recipient);

            try {
                messageService.addMessage(message);
                model.addAttribute("allUsers", userService.getAllLogin());
                model.addAttribute("success", true);
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", true);
                model.addAttribute("message", e.getMessage());
            }
            return "/views/message.jsp";
        }
    }
}
