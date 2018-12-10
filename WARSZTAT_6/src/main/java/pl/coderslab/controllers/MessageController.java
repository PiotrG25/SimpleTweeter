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
@RequestMapping("/message/{userId}")
public class MessageController {

    @Autowired
    HttpSession session;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping
    public String getConversation(Model model, @PathVariable(value = "userId") Long id){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        List<Message> messages = messageRepository.findConversationByUsers(
                (User)session.getAttribute("user"), userRepository.findOne(id));
        model.addAttribute("messages", messages);
        model.addAttribute("messageDto", new MessageDto());

        return "conversation";
    }

    @PostMapping
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

        return "redirect:/message/" + id;
    }
}
