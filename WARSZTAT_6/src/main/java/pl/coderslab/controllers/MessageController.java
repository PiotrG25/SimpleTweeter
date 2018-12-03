package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    HttpSession session;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("?userId")
    public String postMessage(@RequestParam Long userId){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        return "conversation";
    }
    @GetMapping
    public String getMapping(Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        return "message";
    }

    public class SimpleUser{
        private Long id;
        private String name;
        public SimpleUser(Long id, String name){
            this.id = id;
            this.name = name;
        }
        public Long getId(){
            return id;
        }
        public String getName(){
            return name;
        }
    }

    @ModelAttribute("users")
    public List<SimpleUser> users(){
        List<SimpleUser> simpleUsers = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User u : users){
            simpleUsers.add(new SimpleUser(u.getId(), u.getName()));
        }
        return simpleUsers;
    }
}
