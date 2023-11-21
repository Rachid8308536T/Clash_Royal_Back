package ClashRoyale.Deck;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Decks")
@RequiredArgsConstructor
public class DeckCardController {

    private final DeckCardService deckCardService;

    @PostMapping("/bind/deckId={deckId}/cardId={cardId}")
    public Deck binCardIntoDeck(
            @PathVariable("deckId") Long deckId,
            @PathVariable("cardId") Long cardId) {
                return deckCardService.addCardIntoDeck(deckId, cardId);

    }
}
