package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select m from Message m where m.fromUser = ?1 and m.toUser = ?2 or m.fromUser = ?2 and m.toUser = ?1 order by m.date asc")
    List<Message> findConversationByUsers(User fromUser, User toUser);
}
