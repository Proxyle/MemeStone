package Logic.Card.Minion;

import Logic.Card.Card;
import Logic.Card.Rarity;

public class Minion extends Card {
    private int attackPoints;
    private int healthPoints;
    private IMinionState currentState;

    public Minion(Rarity rarity, String name, String context, int cost, int attackPoints, int healthPoints) {
        super(rarity, name, context, cost);
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        setCurrentState(new AliveState());
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setCurrentState(final IMinionState currentState) {
        this.currentState = currentState;
    }
}
