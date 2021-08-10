package by.it_academy.jd2.controller.web.jsp;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.service.api.IAuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value = "login")
@RequestMapping(value = "/signIn")
public class SignInServletJsp {

    private final IAuthUser authUser;

    public SignInServletJsp(IAuthUser authUser ) {
        this.authUser = authUser;
    }

    @GetMapping
    protected String doGet() {
        return "/views/signIn.jsp";
    }

    @PostMapping
    protected String doPost(@RequestParam(name = "login") String login,
                            @RequestParam(name = "password") String password,
                            Model model) {
        try {
            User user = authUser.signIn(login, password);
            if (user == null) {
                throw new IllegalArgumentException("Введен не верный логин или пароль");
            } else {
                model.addAttribute("login", login);
                return "/";
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", true);
            model.addAttribute("message", e.getMessage());
            return "/views/signIn.jsp";
        }
    }

}
