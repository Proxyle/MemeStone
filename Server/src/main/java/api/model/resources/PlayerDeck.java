package api.model.resources;

import api.model.Card;
import api.model.Player;

import java.util.List;

public class PlayerDeck {
    private Player player;
    private List<Card> deck;

    public PlayerDeck(Player player, List<Card> deck) {
        this.player = player;
        this.deck = deck;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Card> getDeck() {
        return deck;
    }
}
