package Models;

import Models.Cards.Card;

import java.util.List;

public class Deck {

    private List<Card> cards;

    public Card getCard(int id){
        return cards.get(id);
    }

    public int getDeckSize(){
        return cards.size();
    }

    public void removeCard(Card c){
        for (Card card : cards){
            if (c.getName().equals(card.getName())){
                cards.remove(card);
                return;
            }
        }
    }
}