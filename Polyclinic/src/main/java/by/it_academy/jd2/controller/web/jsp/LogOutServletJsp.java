package by.it_academy.jd2.controller.web.jsp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/logOut")
public class LogOutServletJsp {

    @GetMapping
    protected String doGet(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/index.jsp";
    }

}
