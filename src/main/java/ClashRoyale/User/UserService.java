package ClashRoyale.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;


        public List<User> getAll() {
            // Récupère tous les utilisateurs.
            return repository.findAll();
        }

        public User getById(Long id) {
            // Récupère un utilisateur par son Id.
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        }

        public User create(User user) {
            // Création d'un utilisateur.
            return repository.save(user);
        }

        public User update(Long id, User user) {
            // Met à jour un utilisateur par son id.
            User userToBeUpdated = getById(id);

            userToBeUpdated.setPseudonyme(user.getPseudonyme());
            userToBeUpdated.setMail(user.getMail());
            userToBeUpdated.setPassword(user.getPassword());
            userToBeUpdated.setRole(user.getRole());

            return repository.save(userToBeUpdated);
        }

        public void delete(Long id) {
            // Supprime un utilisateur par son Id.
            repository.deleteById(id);
        }
    }


