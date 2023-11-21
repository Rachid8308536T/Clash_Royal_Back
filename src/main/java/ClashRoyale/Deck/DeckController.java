package ClashRoyale.Deck;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService service;
    @GetMapping
    ResponseEntity<List<Deck>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Deck> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Deck> create(@RequestBody Deck deck) {
        return new ResponseEntity<>(service.create(deck), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    ResponseEntity<Deck> update(@PathVariable Long id, @RequestBody Deck deck){
        return new ResponseEntity<>(service.update(id, deck), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
