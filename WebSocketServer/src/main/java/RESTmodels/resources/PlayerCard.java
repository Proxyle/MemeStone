package RESTmodels.resources;

import RESTmodels.Card;
import RESTmodels.Player;

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