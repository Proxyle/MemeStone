package Websockets.Shared.messages;

import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.DamageSpell;
import Models.Card.Spell.DrawSpell;
import Models.Card.Spell.HealSpell;
import Models.Card.Spell.ResurrectSpell;
import Models.User.Player;

import java.util.ArrayList;
import java.util.List;

public class SaveDeckMessage {
    ArrayList<Card> minionsInDeck = new ArrayList();
    ArrayList<Card> damageSpellsInDeck = new ArrayList();
    ArrayList<Card> drawSpellsInDeck = new ArrayList();
    ArrayList<Card> healSpellsInDeck = new ArrayList();
    ArrayList<Card> resurrectSpellsInDeck = new ArrayList();

    ArrayList<Card> minionsInCollection = new ArrayList();
    ArrayList<Card> damageSpellsInCollection = new ArrayList();
    ArrayList<Card> drawSpellsInCollection = new ArrayList();
    ArrayList<Card> healSpellsInCollection = new ArrayList();
    ArrayList<Card> resurrectSpellsInCollection = new ArrayList();



    public SaveDeckMessage(List<Card> collection, List<Card> deck) {
        for (Card c : deck){
            if (c instanceof Minion){
                this.minionsInDeck.add(c);
            } else if (c instanceof DamageSpell){
                this.damageSpellsInDeck.add(c);
            } else if (c instanceof DrawSpell){
                this.drawSpellsInDeck.add(c);
            } else if (c instanceof HealSpell){
                this.healSpellsInDeck.add(c);
            } else if (c instanceof ResurrectSpell){
                this.resurrectSpellsInDeck.add(c);
            }
        }
        for (Card c : collection){
            if (c instanceof Minion){
                this.minionsInCollection.add(c);
            } else if (c instanceof DamageSpell){
                this.damageSpellsInCollection.add(c);
            } else if (c instanceof DrawSpell){
                this.drawSpellsInCollection.add(c);
            } else if (c instanceof HealSpell){
                this.healSpellsInCollection.add(c);
            } else if (c instanceof ResurrectSpell){
                this.resurrectSpellsInCollection.add(c);
            }
        }
    }

    public List<Card> getDeck(){
        ArrayList<Card> cards = (ArrayList<Card>) minionsInDeck.clone();
        cards.addAll(damageSpellsInDeck);
        cards.addAll(drawSpellsInDeck);
        cards.addAll(healSpellsInDeck);
        cards.addAll(resurrectSpellsInDeck);
        return cards;
    }

    public List<Card> getCollection(){
        ArrayList<Card> cards = (ArrayList<Card>) minionsInCollection.clone();
        cards.addAll(damageSpellsInCollection);
        cards.addAll(drawSpellsInCollection);
        cards.addAll(healSpellsInCollection);
        cards.addAll(resurrectSpellsInCollection);
        return cards;
    }
}
