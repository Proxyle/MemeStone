package Models;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Cards.Spells.DamageSpell;
import Models.Cards.Spells.DrawSpell;
import Models.Cards.Spells.HealSpell;
import Models.Cards.Spells.ResurrectSpell;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    ArrayList<Minion> minions = new ArrayList();
    ArrayList<DamageSpell> damageSpells = new ArrayList();
    ArrayList<DrawSpell> drawSpells = new ArrayList();
    ArrayList<HealSpell> healSpells = new ArrayList();
    ArrayList<ResurrectSpell> resurrectSpells = new ArrayList();

    public Deck(ArrayList<Minion> minions, ArrayList<DamageSpell> damageSpells, ArrayList<DrawSpell> drawSpells, ArrayList<HealSpell> healSpells, ArrayList<ResurrectSpell> resurrectSpells){
        this.minions = minions;
        this.damageSpells = damageSpells;
        this.drawSpells = drawSpells;
        this.healSpells = healSpells;
        this.resurrectSpells = resurrectSpells;
        fixNull();
    }

    private void fixNull(){
        if (minions == null){
            minions = new ArrayList<>();
        }
        if (damageSpells == null){
            damageSpells = new ArrayList<>();
        }
        if (drawSpells == null){
            drawSpells = new ArrayList<>();
        }
        if (healSpells == null){
            healSpells = new ArrayList<>();
        }
        if (resurrectSpells == null){
            resurrectSpells = new ArrayList<>();
        }
    }

    public Card getCard(int id){
        fixNull();
        if (id < minions.size())
            return minions.get(id);
        id -= minions.size();
        if (id < damageSpells.size())
            return damageSpells.get(id);
        id -= damageSpells.size();
        if (id < drawSpells.size())
            return drawSpells.get(id);
        id -= drawSpells.size();
        if (id < healSpells.size())
            return healSpells.get(id);
        id -= healSpells.size();
        if (id < resurrectSpells.size())
            return resurrectSpells.get(id);
        return null;
    }

    public int getDeckSize(){
        fixNull();

        return minions.size()+damageSpells.size()+drawSpells.size()+healSpells.size()+resurrectSpells.size();
    }

    public void removeCard(Card c){
        fixNull();
        for (Card card : minions){
            if (c.getName().equals(card.getName())){
                minions.remove(card);
                return;
            }
        }
        for (Card card : damageSpells){
            if (c.getName().equals(card.getName())){
                damageSpells.remove(card);
                return;
            }
        }
        for (Card card : drawSpells){
            if (c.getName().equals(card.getName())){
                drawSpells.remove(card);
                return;
            }
        }
        for (Card card : healSpells){
            if (c.getName().equals(card.getName())){
                healSpells.remove(card);
                return;
            }
        }
        for (Card card : resurrectSpells){
            if (c.getName().equals(card.getName())){
                resurrectSpells.remove(card);
                return;
            }
        }
    }
}