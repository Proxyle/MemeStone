package Models;


import Models.Card.Card;
import Models.Card.Deck;
import Models.Card.Minion.Minion;
import Models.Card.Spell.DamageSpell;
import Models.Card.Spell.DrawSpell;
import Models.Card.Spell.HealSpell;
import Models.Card.Spell.ResurrectSpell;

import java.util.ArrayList;
import java.util.List;
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

    public String getUsername() {
        return userName;
    }

    public List<Card> getCards() {
        List<Card> cardsInHand = new ArrayList<>();
        cardsInHand.addAll(minionInHand);
        cardsInHand.addAll(damageSpellsInHand);
        cardsInHand.addAll(drawSpellsInHand);
        cardsInHand.addAll(healSpellsInHand);
        cardsInHand.addAll(resurrectSpellsInHand);
        return cardsInHand;
    }
}
