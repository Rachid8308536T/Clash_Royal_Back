package ClashRoyale.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Users")
@RequiredArgsConstructor
public class UserController {

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
