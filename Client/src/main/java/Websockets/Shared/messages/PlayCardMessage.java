package Websockets.Shared.messages;

import Models.Card.Card;

public class PlayCardMessage {
    Card card;
    int location;

    public Card getCard() {
        return card;
    }

    public int getLocation() {
        return location;
    }

    public PlayCardMessage(Card card, int location){
        this.card = card;
        this.location = location;
    }
}
