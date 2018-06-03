package Models;

import Logic.GameLobby.IGameLogic;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Cards.Spells.DamageSpell;
import Models.Cards.Spells.DrawSpell;
import Models.Cards.Spells.HealSpell;
import Models.Cards.Spells.ResurrectSpell;

import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    String sessionId;
    String userName;
    Deck deck;
    ArrayList<Minion> minionInHand = new ArrayList();
    ArrayList<DamageSpell> damageSpellsInHand = new ArrayList();
    ArrayList<DrawSpell> drawSpellsInHand = new ArrayList();
    ArrayList<HealSpell> healSpellsInHand = new ArrayList();
    ArrayList<ResurrectSpell> resurrectSpellsInHand = new ArrayList();

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

        if (deck.getDeckSize() != 0) {
            Random r = new Random();
            Card c = deck.getCard(r.nextInt(deck.getDeckSize()));
            //add card to hand
            deck.removeCard(c);
        }
    }

    public boolean playCard(Card card, IGameLogic gameLogic, int[] location){
        ArrayList<Card> hand = (ArrayList<Card>)minionInHand.clone();
        hand.addAll(damageSpellsInHand); hand.addAll(drawSpellsInHand); hand.addAll(healSpellsInHand); hand.addAll(resurrectSpellsInHand);
        if (hand.size() != 0) {
            for (Card c : hand) {
                if (c.getName().equals(card.getName())) {
                    if (card.play(gameLogic, location)) {
                        removeCard(c);
                        //hand.remove(c);
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public void removeCard(Card c){
        for (Minion minion : minionInHand){
            if (minion.getName().equals(c.getName())){
                minionInHand.remove(minion);
                return;
            }
        }
        for (DamageSpell damageSpell : damageSpellsInHand){
            if (damageSpell.getName().equals(c.getName())){
                damageSpellsInHand.remove(damageSpell);
                return;
            }
        }
        for (DrawSpell drawSpell : drawSpellsInHand){
            if (drawSpell.getName().equals(c.getName())){
                drawSpellsInHand.remove(drawSpell);
                return;
            }
        }
        for (HealSpell healSpell : healSpellsInHand){
            if (healSpell.getName().equals(c.getName())){
                healSpellsInHand.remove(healSpell);
                return;
            }
        }
        for (ResurrectSpell resurrectSpell : resurrectSpellsInHand){
            if (resurrectSpell.getName().equals(c.getName())){
                resurrectSpellsInHand.remove(resurrectSpell);
                return;
            }
        }
    }

}
