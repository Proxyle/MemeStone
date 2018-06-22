package api.model.resources;

import api.model.Card;
import api.model.Player;

public class PlayerCard {
    private Player player;
    private Card card;

    public PlayerCard(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }
}
