package Models;

import Models.Cards.Minion;

public class Board {
    final static int MAX_MANA = 10;
    Field leftField;
    Field rightField;
    int upperHero;
    int lowerHero;
    int upperHeroMana;
    int lowerHeroMana;
    int upperHeroMaxMana;
    int lowerHeroMaxMana;

    public Board(int heroHealth){
        leftField = new Field();
        rightField = new Field();
        upperHero = heroHealth;
        lowerHero = heroHealth;
    }

    public Board(Field leftField, Field rightField, int upperHero, int upperHeroMana, int upperHeroMaxMana, int lowerHero, int lowerHeroMana, int lowerHeroMaxMana){
        this.leftField = leftField;
        this.rightField = rightField;
        this.upperHero = upperHero;
        this.upperHeroMana = upperHeroMana;
        this.upperHeroMaxMana = upperHeroMaxMana;
        this.lowerHero = lowerHero;
        this.lowerHeroMana = lowerHeroMana;
        this.lowerHeroMaxMana = lowerHeroMaxMana;
    }

    public int getLowerHero() {
        return lowerHero;
    }

    public int getLowerHeroMana() {
        return lowerHeroMana;
    }

    public int getLowerHeroMaxMana(){
        return lowerHeroMaxMana;
    }

    public int getUpperHero() {
        return upperHero;
    }

    public int getUpperHeroMana() {
        return upperHeroMana;
    }

    public int getUpperHeroMaxMana(){
        return upperHeroMaxMana;
    }

    public Field getLeftField() {
        return leftField;
    }

    public Field getRightField() {
        return rightField;
    }

    public Board flipBoard(){
        return new Board(rightField.flipField(), leftField.flipField(), lowerHero, lowerHeroMana, lowerHeroMaxMana, upperHero, upperHeroMana, upperHeroMaxMana);
    }

    public boolean placeMinion(Minion minion, int location){
        if (minion.getCost() > lowerHeroMana)
            return false;
        boolean success;
        if (location > 3)
            success = rightField.placeMinion(minion, location-3);
        else
            success = leftField.placeMinion(minion, location);
        if (success)
            lowerHeroMana-=minion.getCost();
        return success;
    }

    public boolean attack(int attacker, int defender){
        if (attacker > 3)
            return rightField.attack(attacker-3, defender-3);
        return leftField.attack(attacker, defender);
    }

    public boolean attackOpponentHero(int attacker){
        int damage;
        if (attacker > 3)
            damage = rightField.getDamage(attacker-3);
        else
            damage = leftField.getDamage(attacker);
        upperHero-=damage;
        return upperHero < 1;
    }

    public boolean canAttackHero(int attacker){
        if (attacker > 3)
            return rightField.isLaneClear();
        return leftField.isLaneClear();
    }

    public boolean damage(int location, int damage, boolean own){
        if (location > 3)
            return rightField.damage(location-3, damage, own);
        return leftField.damage(location, damage, own);
    }

    public void newTurn(){
        if (lowerHeroMaxMana < MAX_MANA)
            lowerHeroMaxMana++;
        lowerHeroMana = lowerHeroMaxMana;
    }
}
