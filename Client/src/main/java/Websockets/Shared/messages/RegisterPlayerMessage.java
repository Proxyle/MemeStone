package Messages.ClientToServer;

import Models.Deck;

public class RegisterPlayerMessage {
    String userName;
    Deck deck;

    public Deck getDeck() {
        return deck;
    }

    public String getUserName() {
        return userName;
    }

    public RegisterPlayerMessage(String userName, Deck deck){
        this.userName = userName;
        this.deck = deck;
    }
}
