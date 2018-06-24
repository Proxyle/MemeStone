package Websockets.Shared.messages;


import Models.Deck;

public class RegisterPlayerMessage {
    String userName;
    Deck deck;

    public String getUserName() {
        return userName;
    }

    public Deck getDeck() {
        return deck;
    }

    public RegisterPlayerMessage(String userName, Deck deck) {
        this.userName = userName;
        this.deck = deck;
    }
}
