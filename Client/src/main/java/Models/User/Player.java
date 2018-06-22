package Models.User;


import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.DamageSpell;
import Models.Card.Spell.DrawSpell;
import Models.Card.Spell.HealSpell;
import Models.Card.Spell.ResurrectSpell;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    String sessionId;
    String userName;
    String password;
    String email;
    int id;
    int score;

    ArrayList<Minion> minionInHand = new ArrayList();
    ArrayList<DamageSpell> damageSpellsInHand = new ArrayList();
    ArrayList<DrawSpell> drawSpellsInHand = new ArrayList();
    ArrayList<HealSpell> healSpellsInHand = new ArrayList();
    ArrayList<ResurrectSpell> resurrectSpellsInHand = new ArrayList();

    List<Card> collection;
    List<Card> deck;
    List<String> quests;

    public String getName(){
        return userName;
    }

    public String getSessionId(){
        return sessionId;
    }

    public ArrayList<Card> getCards(){
        ArrayList<Card> hand = (ArrayList<Card>)minionInHand.clone();
        hand.addAll(damageSpellsInHand);
        hand.addAll(drawSpellsInHand);
        hand.addAll(healSpellsInHand);
        hand.addAll(resurrectSpellsInHand);
        return hand;
    }

    public Player(String sessionId, String userName, String email, long id, int points, List<Card> collection){
        this.sessionId = sessionId;
        this.userName = userName;
        this.email = email;
        this.id = (int) id;
        this.score = points;
        this.collection = collection;
    }

    public List<Card> getCollection() {
        return (ArrayList) collection;
    }

    public List<Card> getDeck() {
        return (ArrayList) deck;
    }

    @Override
    public List<String> getQuests() {
        return null;
    }

    @Override
    public int getRanking() {
        return score;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
