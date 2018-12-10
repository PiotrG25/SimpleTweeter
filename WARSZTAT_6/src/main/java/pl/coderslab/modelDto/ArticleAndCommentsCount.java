package pl.coderslab.modelDto;

import pl.coderslab.entity.Article;

public class ArticleAndCommentsCount {
    private Article article;
    private Long commentsCount;
    public ArticleAndCommentsCount(Article article, Long commentsCount){
        this.article = article;
        this.commentsCount = commentsCount;
    }
    public Article getArticle(){
        return this.article;
    }
    public Long getCommentsCount(){
        return this.commentsCount;
    }
}
