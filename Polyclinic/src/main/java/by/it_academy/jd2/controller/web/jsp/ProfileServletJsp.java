package by.it_academy.jd2.controller.web.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileServletJsp {

    public ProfileServletJsp() {
    }

    @GetMapping(produces = {"text/html"})
    protected String getAllHtml() {
        return "/views/profile.jsp";
    }
}
