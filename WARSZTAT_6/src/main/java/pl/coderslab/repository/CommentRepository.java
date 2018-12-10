package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByArticleIdOrderByDateDesc(Long id);

    Long countCommentsByArticle(Article article);
}
