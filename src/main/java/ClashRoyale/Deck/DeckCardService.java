package ClashRoyale.Deck;

import ClashRoyale.Card.Card;
import ClashRoyale.Card.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeckCardService {

    private final DeckRepository deckRepository;

    private final CardRepository cardRepository;

    public Deck addCardIntoDeck(Long deckId, Long cardId){
        Deck deck = deckRepository.findById(deckId).orElseThrow(() -> new EntityNotFoundException(deckId + " does not found"));
        Card card = cardRepository.findById(deckId).orElseThrow(() -> new EntityNotFoundException(cardId + " does not found"));
        deck.getCards().add(card);
        deckRepository.save(deck);
        return deck;
    }
}
