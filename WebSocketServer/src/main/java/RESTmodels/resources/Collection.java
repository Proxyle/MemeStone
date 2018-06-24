package RESTmodels.resources;



import RESTmodels.Card;
import RESTmodels.Player;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User_Card")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Player player;

    private Collection() {}

    public Collection(Card card, Player player) {
        this.card = card;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Collection that = (Collection)o;
        return Objects.equals(card, that.getCard()) && Objects.equals(player, that.getPlayer());
    }
}
