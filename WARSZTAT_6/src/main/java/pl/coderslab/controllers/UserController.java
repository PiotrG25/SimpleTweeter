package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.modelDto.ArticleAndComments;
import pl.coderslab.modelDto.SimpleUser;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;


    @GetMapping
    public String getUsers(){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserId(Model model, @PathVariable Long id){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(id == ((User)session.getAttribute("user")).getId()){
            return "sessionUser";
        }

        model.addAttribute("thisUser", userRepository.findOne(id));
        model.addAttribute("articlesAndComments", ArticleAndComments.articlesAndCommentsByUserId(articleRepository, userRepository, commentRepository, id));
        return "user";
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
