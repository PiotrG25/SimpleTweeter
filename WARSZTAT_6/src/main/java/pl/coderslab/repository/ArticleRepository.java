package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.User;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select a from Article a order by date desc")
    List<Article> findArticlesOrderByDateDesc();

    List<Article> findArticlesByUserOrderByDateDesc(User user);
}
