package ClashRoyale.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPseudonyme(String pseudonyme);
}
