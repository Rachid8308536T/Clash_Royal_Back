package ClashRoyale.Deck;

import ClashRoyale.Card.Card;
import ClashRoyale.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate creationDate;
    private String clan;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("decks")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("decks")
    private Set<Card> cards = new HashSet<>();
}
