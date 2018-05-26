package Models;

import Logic.GameLobby.IGameLogic;
import Models.Cards.Card;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    String sessionId;
    String userName;
    Deck deck;
    ArrayList<Card> hand = new ArrayList();

    public String getName(){
        return userName;
    }

    public String getSessionId(){
        return sessionId;
    }

    public Player(String sessionId, String userName, Deck deck){
        this.sessionId = sessionId;
        this.userName = userName;
        this.deck = deck;

    }

    public void drawCard(){
        Random r = new Random();
        Card c = deck.getCard(r.nextInt(deck.getDeckSize()));
        hand.add(c);
        deck.removeCard(c);
    }

    public boolean playCard(Card card, IGameLogic gameLogic, int[] location){
        for (Card c : hand){
            if (c.getName().equals(card.getName())){
                if (card.play(gameLogic, location)) {
                    hand.remove(c);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

}
