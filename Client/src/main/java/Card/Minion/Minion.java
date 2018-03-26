package Card.Minion;

import Card.Card;
import Card.Rarity;

public class Minion extends Card {
    private int attackPoints;
    private int healthPoints;

    public Minion(Rarity rarity, String name, String context, int cost, int attackPoints, int healthPoints) {
        super(rarity, name, context, cost);
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
