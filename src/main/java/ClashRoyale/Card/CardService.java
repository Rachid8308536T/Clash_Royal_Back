package ClashRoyale.Card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository repository;

    public List<Card> getAll() {
        // Récupère toutes les cartes.
        return repository.findAll();
    }

    public Card getById(Long id) {
        // Récupère une carte par son Id.
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with the id: " + id));
    }

    public Card getByName(String name) {
        if(repository.findByName(name).isEmpty()){
            throw new RuntimeException("Card not found with the name: " + name);
        }
        // Récupère une carte par son Name.
        return repository.findByName(name).get();

    }

    public Card create(Card card) {
        // Création d'une carte.
        return repository.save(card);
    }

    public Card update(Long id, Card card) {
        // Met à jour un utilisateur par son Id.
        Card cardToBeUpdated = getById(id);

        cardToBeUpdated.setName(card.getName());
        cardToBeUpdated.setImage(card.getImage());
        cardToBeUpdated.setType(card.getType());
        cardToBeUpdated.setRarete(card.getRarete());
        cardToBeUpdated.setElixir(card.getElixir());
        cardToBeUpdated.setDescription(card.getDescription());

        return repository.save(cardToBeUpdated);
    }

    public void delete(Long id) {
        // Supprime une carte par son Id.
        repository.deleteById(id);
    }
}
