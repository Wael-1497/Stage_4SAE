package tn.sae.chat.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sae.chat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickName(String nickName);
}
