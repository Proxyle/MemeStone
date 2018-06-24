package Models.Board;

import Models.Card.Minion.Minion;

public class Board {
    Field leftField;
    Field rightField;
    int upperHero;
    int lowerHero;
    int upperHeroMana;
    int lowerHeroMana;

    public Board(int heroHealth){
        leftField = new Field();
        rightField = new Field();
        upperHero = heroHealth;
        lowerHero = heroHealth;
    }

    public Board(Field leftField, Field rightField, int upperHero, int lowerHero){
        this.leftField = leftField;
        this.rightField = rightField;
        this.upperHero = upperHero;
        this.lowerHero = lowerHero;
    }

    public Field getLeftField() {
        return leftField;
    }

    public Field getRightField() {
        return rightField;
    }

    public int getLowerHero() {
        return lowerHero;
    }

    public int getLowerHeroMana() {
        return lowerHeroMana;
    }

    public int getUpperHero() {
        return upperHero;
    }

    public int getUpperHeroMana() {
        return upperHeroMana;
    }

    public Board flipBoard(){
        return new Board(rightField.flipField(), leftField.flipField(), lowerHero, upperHero);
    }

    public boolean placeMinion(Minion minion, int location){
        if (location > 3)
            return rightField.placeMinion(minion, location-3);
        return leftField.placeMinion(minion, location);
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
}
