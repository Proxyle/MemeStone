package api.model.resources;

import api.model.Card;
import api.model.Player;

import javax.persistence.*;

@Entity
@Table(name = "User_Card")
public class Collection {
    private Card card;
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "card_id")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
