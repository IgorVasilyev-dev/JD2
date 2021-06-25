package by.it_academy.jd2.controller.web.servlets;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.view.api.IAuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value = "user")
@RequestMapping(value = "/signIn")
public class SignInServlet {

    private final IAuthUser authUser;

    public SignInServlet(IAuthUser authUser ) {
        this.authUser = authUser;
    }

    @GetMapping
    protected String doGet() {
        return "/views/signIn.jsp";
    }

    @PostMapping
    protected String doPost(@RequestParam(name = "login") String login,
                          @RequestParam(name = "pass") String password,
                          Model model) {
        try {
            User user = authUser.checkAuthUser(login, password);
            if (user == null) {
                throw new IllegalArgumentException("Введен не верный логин или пароль");
            } else {
                model.addAttribute("user", user);
                return "/";
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", true);
            model.addAttribute("message", e.getMessage());
            return "/views/signIn.jsp";
        }
    }
}
