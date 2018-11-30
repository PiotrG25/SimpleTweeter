package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    HttpSession session;

    @RequestMapping("/logout")
    public String logout(){
        session.invalidate();
        return "redirect:/";
    }
}
