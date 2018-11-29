package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserDto;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
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

    @PostMapping
    public String postRegister(Model model, @Valid @ModelAttribute UserDto userDto, BindingResult result){
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

        if(userRepository.findUserByEmail(userDto.getEmail()) != null){
            model.addAttribute("emailTaken", true);
            return "register";
        }

        User user = userDto.getUser();
        user.hashPassword();
        userRepository.save(user);

        session.setAttribute("user", user);
        session.setMaxInactiveInterval(15 * 60);

        return "redirect:/";
    }

    @GetMapping
    public String getRegister(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }
}
