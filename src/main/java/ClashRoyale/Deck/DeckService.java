package ClashRoyale.Deck;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final DeckRepository repository;


    public List<Deck> getAll() {
        // Récupère tous les decks.
        return repository.findAll();
    }

    public Deck getById(Long id) {
        // Récupère un deck par son Id.
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck not found with id: " + id));
    }

    public Deck create(Deck deck) {
        // Création d'un deck.
        return repository.save(deck);
    }

    public Deck update(Long id, Deck deck) {
        // Met à jour un utilisateur par son id.
        Deck deckToBeUpdated = getById(id);

        deckToBeUpdated.setName(deck.getName());
        deckToBeUpdated.setCreationDate(deck.getCreationDate());
        deckToBeUpdated.setClan(deck.getClan());

        return repository.save(deckToBeUpdated);
    }

    public void delete(Long id) {
        // Supprime un deck par son Id.
        repository.deleteById(id);
    }
}
