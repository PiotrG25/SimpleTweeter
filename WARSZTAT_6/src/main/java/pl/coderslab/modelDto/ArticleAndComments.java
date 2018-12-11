package pl.coderslab.modelDto;

import pl.coderslab.entity.Article;
import pl.coderslab.entity.Comment;

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
