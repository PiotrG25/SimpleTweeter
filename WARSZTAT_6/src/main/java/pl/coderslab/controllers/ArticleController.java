package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.ArticleDto;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.User;
import pl.coderslab.modelDto.ArticleAndComments;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    HttpSession session;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;


    @GetMapping
    public String getArticle(Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        model.addAttribute("articleDto", new ArticleDto());
        model.addAttribute("articlesAndComments", ArticleAndComments.articlesAndCommentsAll(articleRepository, commentRepository));
        return "articles";
    }

    @PostMapping
    public String postArticle(@Valid @ModelAttribute ArticleDto articleDto, BindingResult result){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "articles";
        }

        Article article = new Article(articleDto.getDescription(), (User)session.getAttribute("user"), LocalDateTime.now());
        articleRepository.save(article);

        return "redirect:/article";
    }
}
