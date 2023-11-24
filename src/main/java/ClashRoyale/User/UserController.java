package ClashRoyale.User;

import ClashRoyale.Card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Users")
@RequiredArgsConstructor

public class UserController {
    private final UserRepository repository;
    private final UserService service;
    @GetMapping
    ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

   @PostMapping("/signin")
   ResponseEntity<Map<String, String>> signin(@RequestBody UserDTO userDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            if (service.checkIfExist(userDTO)) {
                User user = repository.findByPseudonyme(userDTO.getPseudonyme());
                response.put("message", "Connexion réussie");
                response.put("user", user.getPseudonyme());
                response.put("role", user.getRole());
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Identifiants incorrects");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Erreur interne du serveur");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(service.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
