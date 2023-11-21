package ClashRoyale.Deck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
    @Query("SELECT d.user.id FROM Deck d WHERE d.id = :deckId")
    Long findUserIdByDeckId(@Param("deckId") Long deckId);
}
