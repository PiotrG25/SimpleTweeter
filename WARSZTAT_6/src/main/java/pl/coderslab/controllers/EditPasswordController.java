package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserEditPasswordDto;
import pl.coderslab.entity.User;
import pl.coderslab.other.BCrypt;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("editPassword")
public class EditPasswordController {

    @Autowired
    HttpSession session;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String getEditPassword(Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        model.addAttribute("userEditPasswordDto", new UserEditPasswordDto());
        return "editPassword";
    }

    @PostMapping
    public String postEditPassword(Model model, @Valid @ModelAttribute UserEditPasswordDto userEditPasswordDto, BindingResult result){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "editPassword";
        }

        String oldPassword = userEditPasswordDto.getOldPassword();
        String newPassword = userEditPasswordDto.getNewPassword();
        String newPassword2 = userEditPasswordDto.getNewPassword2();
        User user = (User)session.getAttribute("user");
        String userSessionPassword = user.getPassword();

        if (!BCrypt.checkpw(oldPassword, userSessionPassword)) {
            model.addAttribute("wrongPassword", true);
            return "editPassword";
        }

        if(!newPassword.equals(newPassword2)){
            model.addAttribute("differentPasswords", true);
            return "editPassword";
        }

        user.setPassword(newPassword);
        user.hashPassword();
        userRepository.save(user);

        return "redirect:/user/" + user.getId();
    }
}
