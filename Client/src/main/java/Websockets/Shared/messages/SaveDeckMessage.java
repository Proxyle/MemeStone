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
    ArrayList<Minion> minionsInDeck = new ArrayList();
    ArrayList<DamageSpell> damageSpellsInDeck = new ArrayList();
    ArrayList<DrawSpell> drawSpellsInDeck = new ArrayList();
    ArrayList<HealSpell> healSpellsInDeck = new ArrayList();
    ArrayList<ResurrectSpell> resurrectSpellsInDeck = new ArrayList();

    public SaveDeckMessage(List<Card> collection, List<Card> deck) {
        for (Card c : deck){
            if (c instanceof Minion){
                this.minionsInDeck.add((Minion)c);
            } else if (c instanceof DamageSpell){
                this.damageSpellsInDeck.add((DamageSpell)c);
            } else if (c instanceof DrawSpell){
                this.drawSpellsInDeck.add((DrawSpell)c);
            } else if (c instanceof HealSpell){
                this.healSpellsInDeck.add((HealSpell)c);
            } else if (c instanceof ResurrectSpell){
                this.resurrectSpellsInDeck.add((ResurrectSpell)c);
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
}
