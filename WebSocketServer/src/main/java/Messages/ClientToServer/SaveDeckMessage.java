package Messages.ClientToServer;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Cards.Spells.DamageSpell;
import Models.Cards.Spells.DrawSpell;
import Models.Cards.Spells.HealSpell;
import Models.Cards.Spells.ResurrectSpell;

import java.util.ArrayList;
import java.util.List;

public class SaveDeckMessage {
    int playerId;
    ArrayList<Minion> minionsInDeck = new ArrayList();
    ArrayList<DamageSpell> damageSpellsInDeck = new ArrayList();
    ArrayList<DrawSpell> drawSpellsInDeck = new ArrayList();
    ArrayList<HealSpell> healSpellsInDeck = new ArrayList();
    ArrayList<ResurrectSpell> resurrectSpellsInDeck = new ArrayList();

    public int getPlayerId() {
        return playerId;
    }

    public SaveDeckMessage(int playerId, List<Card> deck) {
        this.playerId = playerId;
        for (Card c : deck){
            if (c instanceof Minion){
                this.minionsInDeck.add((Minion)c);
            } else if (c instanceof DamageSpell){
                this.damageSpellsInDeck.add((DamageSpell) c);
            } else if (c instanceof DrawSpell){
                this.drawSpellsInDeck.add((DrawSpell) c);
            } else if (c instanceof HealSpell){
                this.healSpellsInDeck.add((HealSpell) c);
            } else if (c instanceof ResurrectSpell){
                this.resurrectSpellsInDeck.add((ResurrectSpell) c);
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