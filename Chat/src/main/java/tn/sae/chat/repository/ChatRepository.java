package tn.sae.chat.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sae.chat.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByOrderByCreatedOnDesc();
}
