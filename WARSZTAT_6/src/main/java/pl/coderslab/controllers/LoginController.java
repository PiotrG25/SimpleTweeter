package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    /*Strona ma przyjmować email użytkownika i jego hasło.

    jeżeli są poprawne, to użytkownik jest przekierowany do strony głównej,

    jeżeli nie – do strony logowania, która ma wtedy wyświetlić komunikat o błędnym loginie lub haśle,
    strona logowania ma mieć też link do strony tworzenia użytkownika.*/

    @PostMapping
    public String postLogin(){
        return null;
    }

    @GetMapping
    public String getLogin(){
        return null;
    }
}
