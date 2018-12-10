package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.CommentDto;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CommentRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment/{id}")
public class CommentController {

    @Autowired
    HttpSession session;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;


    @GetMapping
    public String getComment(@PathVariable Long id, Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        model.addAttribute("article", articleRepository.findOne(id));
        model.addAttribute("comments", commentRepository.findCommentsByArticleIdOrderByDateDesc(id));
        model.addAttribute("commentDto", new CommentDto());
        return "comment";
    }

    @PostMapping
    public String postComment(@PathVariable Long id, @Valid @ModelAttribute CommentDto commentDto, BindingResult result){
        if(session.getAttribute("user") == null){
            return "redirect:/";
        }

        if(result.hasErrors()){
            return "comment";
        }

        Comment comment = new Comment(commentDto.getDescription(), articleRepository.findOne(id),
                (User)session.getAttribute("user"), LocalDateTime.now());
        commentRepository.save(comment);

        return "redirect:/comment/" + id;
    }
}
