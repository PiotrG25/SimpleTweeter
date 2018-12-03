package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.MessageDto;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
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

    @PostMapping("/{userId}")
    public String postConversation(@PathVariable(value = "userId") Long id,
                                   @ModelAttribute @Valid MessageDto messageDto, BindingResult result
    ){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "conversation";
        }

        String description = messageDto.getDescription();
        Message message = new Message(description, (User)session.getAttribute("user"),
                userRepository.findOne(id), LocalDateTime.now());
        messageRepository.save(message);

        return "redirect:/message" + id;
    }
    @GetMapping("/{userId}")
    public String getConversation(Model model, @PathVariable(value = "userId") Long id){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        List<Message> messages = messageRepository.findConversationByFromUserAndToUser(
                (User)session.getAttribute("user"), userRepository.findOne(id));
        model.addAttribute("messages", messages);
        model.addAttribute("messageDto", new MessageDto());

        return "conversation";
    }

    @GetMapping
    public String getMessage(){
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
