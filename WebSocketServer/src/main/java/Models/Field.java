package Models;

import Models.Cards.Minion;

import java.util.Random;

public class Field {
    Minion[] upperField;
    Minion[] lowerField;
    FieldBuff fieldBuff;

    public Field(){
        upperField = new Minion[3];
        lowerField = new Minion[3];
        fieldBuff = FieldBuff.values()[new Random().nextInt(8)];
    }

    public Field(Minion[] upperField, Minion[] lowerField, FieldBuff fieldBuff){
        this.upperField = upperField;
        this.lowerField = lowerField;
        this.fieldBuff = fieldBuff;
    }

    public Field flipField(){
        return new Field(lowerField, upperField, fieldBuff);
    }

    public boolean placeMinion(Minion minion, int location){
        if (fieldBuff == FieldBuff.n1Health)
            if (minion.getHealthPoints()-1 == 0)
                return false;
        if (location > 3 || location < 0)
            return false;
        if (lowerField[location] != null)
            return false;
        lowerField[location] = minion.includeFieldBuff(fieldBuff);
        return true;
    }

    public boolean attack(int attacker, int defender){
        if (defender < 0 || defender > 3)
            return false;
        if (lowerField[attacker] == null || upperField[defender] == null)
            return false;
        if (lowerField[attacker].getAttackPoints() < 1 || lowerField[attacker].hasAttacked())
            return false;
        Minion attacking = lowerField[attacker];
        Minion defending = upperField[defender];
        upperField[defender] = upperField[defender].receiveDamage(attacking.getAttackPoints());
        lowerField[attacker] = lowerField[attacker].receiveDamage(defending.getAttackPoints());
        lowerField[attacker].setAttacked();
        return true;
    }

    public boolean isLaneClear(){
        return upperField[0] == null && upperField[1] == null && upperField[2] == null;
    }

    public int getDamage(int attacker){
        if (lowerField[attacker] == null)
            return 0;
        return lowerField[attacker].getAttackPoints();
    }

    public boolean damage(int location, int damage, boolean own){
        if (own) {
            if (lowerField[location] == null)
                return false;
            lowerField[location] = lowerField[location].receiveDamage(damage);
            return true;
        }
        else{
            if (upperField[location] == null)
                return false;
            upperField[location] = upperField[location].receiveDamage(damage);
            return true;
        }
    }
}
