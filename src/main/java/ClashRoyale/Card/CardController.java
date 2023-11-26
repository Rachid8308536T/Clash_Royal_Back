package ClashRoyale.Card;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Cards")
@RequiredArgsConstructor
public class CardController {
private final CardService service;
    @GetMapping
    public ResponseEntity<List<Card>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Card> getByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card card) {
        service.create(card);
        List<Card> allCards = service.getAll();
        Card lastCard = allCards.get(allCards.size() - 1);
        return new ResponseEntity<>(lastCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card){
        return new ResponseEntity<>(service.update(id, card), HttpStatus.OK);
}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
