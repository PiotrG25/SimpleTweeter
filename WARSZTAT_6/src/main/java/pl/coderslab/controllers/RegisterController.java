package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dto.UserDto;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    /*Strona ma pobierać email i hasło.

    Jeżeli takiego adresu email nie ma jeszcze w systemie (tabeli w bazie)
    , to rejestrujemy użytkownika i logujemy (przekierowanie na stronę główną).

    Jeżeli taki adres email jest, to przekierowujemy do strony tworzenia użytkownika
    (ta sama strona) i wyświetlamy komunikat o zajętym adresie email.*/

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String postRegister(Model model, @ModelAttribute UserDto userDto, BindingResult result){
        if(session.getAttribute("user") != null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "register";
        }

        if(!userDto.getPassword().equals(userDto.getConfirmPassword())){
            model.addAttribute("differentPassword", true);
            return "register";
        }

//        todo dodawanie do DB
        return null;
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }
}
