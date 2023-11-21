package ClashRoyale.Card;

import ClashRoyale.Deck.Deck;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String image;
    private String type;
    private String rarete;
    private int elixir;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "cards")
    @JsonIgnoreProperties("cards")
    private Set<Deck> decks = new HashSet<>();
}
