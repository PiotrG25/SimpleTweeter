package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserRegisterDto;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String postRegister(Model model, @Valid @ModelAttribute UserRegisterDto userRegisterDto, BindingResult result){
        if(session.getAttribute("user") != null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "register";
        }

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            model.addAttribute("differentPassword", true);
            return "register";
        }

        if(userRepository.findUserByEmail(userRegisterDto.getEmail()) != null){
            model.addAttribute("emailTaken", true);
            return "register";
        }

        User user = userRegisterDto.getUser();
        user.hashPassword();
        userRepository.save(user);

        session.setAttribute("user", user);
        session.setMaxInactiveInterval(15 * 60);

        return "redirect:/";
    }

    @GetMapping
    public String getRegister(Model model){
        if(session.getAttribute("user") != null){
            return "redirect:/";
        }

        model.addAttribute("userRegisterDto", new UserRegisterDto());
        return "register";
    }
}
