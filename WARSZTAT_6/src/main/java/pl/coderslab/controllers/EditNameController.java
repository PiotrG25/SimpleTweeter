package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserEditNameDto;
import pl.coderslab.entity.User;
import pl.coderslab.other.BCrypt;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/editName")
public class EditNameController {

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String getEditName(Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        model.addAttribute("userEditNameDto", new UserEditNameDto());

        return "editName";
    }

    @PostMapping
    public String postEditName(Model model, @Valid @ModelAttribute UserEditNameDto userEditNameDto, BindingResult result){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "editName";
        }

        String newName = userEditNameDto.getName();
        String password = userEditNameDto.getPassword();
        User user = (User)session.getAttribute("user");
        String oldPassword = user.getPassword();

        if(!BCrypt.checkpw(password, oldPassword)){
            model.addAttribute("wrongPassword", true);
            return "editName";
        }

        user.setName(newName);
        userRepository.save(user);

        return "redirect:/user/" + user.getId();
    }
}
