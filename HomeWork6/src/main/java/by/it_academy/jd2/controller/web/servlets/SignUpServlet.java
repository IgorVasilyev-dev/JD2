package by.it_academy.jd2.controller.web.servlets;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.view.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(types = User.class)
@RequestMapping(value = "/signUp")
public class SignUpServlet {

    private final IUserService userService;

    public SignUpServlet(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    protected String doGet() {
        return "/views/signUp.jsp";
    }

    @PostMapping
    protected String addUser(@RequestParam(name = "login") String login,
                             @RequestParam(name = "pass") String password,
                             @RequestParam(name = "fio") String fio,
                             @RequestParam(name = "birthDay") String birthDay,
                             Model model) {

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setBirthDay(birthDay);

        try {
            this.userService.checkUser(user);
            model.addAttribute("user", user);
            return "/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", true);
            model.addAttribute("message", e.getMessage());
            return "/views/signUp.jsp";
        }
    }
}
