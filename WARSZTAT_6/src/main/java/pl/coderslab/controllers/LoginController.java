package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserLoginDto;
import pl.coderslab.entity.User;
import pl.coderslab.other.BCrypt;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    /*Strona ma przyjmować email użytkownika i jego hasło.

    jeżeli są poprawne, to użytkownik jest przekierowany do strony głównej,

    jeżeli nie – do strony logowania, która ma wtedy wyświetlić komunikat o błędnym loginie lub haśle,
    strona logowania ma mieć też link do strony tworzenia użytkownika.*/

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String postLogin(Model model, @Valid @ModelAttribute UserLoginDto userLoginDto, BindingResult result){
        if(session.getAttribute("user") != null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "login";
        }

        User user = userRepository.findUserByEmail(userLoginDto.getEmail());

        if(user == null || !BCrypt.checkpw(userLoginDto.getPassword(), user.getPassword())){
            model.addAttribute("error", true);
            return "login";
        }

        session.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping
    public String getLogin(Model model){
        if(session.getAttribute("user") != null){
            return "redirect:/";
        }

        model.addAttribute("userLoginDto", new UserLoginDto());
        return "login";
    }
}
