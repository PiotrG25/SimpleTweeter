package pl.coderslab.modelDto;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class ArticleAndComments{

    private Article article;
    private List<Comment> comments;
    private int commentsCount;


    public ArticleAndComments(Article article, List<Comment> comments){
        this.article = article;
        this.comments = comments;
        this.commentsCount = comments.size();
    }


    public static List<ArticleAndComments> articlesAndCommentsByUserId(ArticleRepository articleRepository, UserRepository userRepository, CommentRepository commentRepository, Long id){
        List<Article> articles = articleRepository.findArticlesByUserOrderByDateDesc(userRepository.findOne(id));
        List<ArticleAndComments> ArticleAndComments = new ArrayList<>();
        for(Article a : articles){
            ArticleAndComments.add(new ArticleAndComments(a, commentRepository.findCommentsByArticleIdOrderByDateDesc(a.getId())));
        }
        return ArticleAndComments;
    }

    public static List<ArticleAndComments> articlesAndCommentsAll(ArticleRepository articleRepository, CommentRepository commentRepository){
        List<Article> articles = articleRepository.findArticlesOrderByDateDesc();
        List<ArticleAndComments> ArticleAndComments = new ArrayList<>();
        for(Article a : articles){
            ArticleAndComments.add(new ArticleAndComments(a, commentRepository.findCommentsByArticleIdOrderByDateDesc(a.getId())));
        }
        return ArticleAndComments;
    }

    public Article getArticle(){
        return this.article;
    }
    public int getCommentsCount(){
        return this.commentsCount;
    }
    public List<Comment> getComments(){
        return this.comments;
    }
}
