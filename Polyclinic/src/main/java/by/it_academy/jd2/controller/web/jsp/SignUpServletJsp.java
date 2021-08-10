package by.it_academy.jd2.controller.web.jsp;

import by.it_academy.jd2.model.User;
import by.it_academy.jd2.service.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes(value = "login")
@RequestMapping(value = "/signUp")
public class SignUpServletJsp {

    private final IUserService userService;

    public SignUpServletJsp(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    protected String doGet() {
        return "/views/signUp.jsp";
    }

    @PostMapping
    protected String addUser(@RequestParam(name = "login") String login,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "tel") String tel,
                             Model model) {

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        try {
            this.userService.checkUser(user);
            model.addAttribute("login", login);
            return "/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", true);
            model.addAttribute("message", e.getMessage());
            return "/views/signUp.jsp";
        }
    }

}
