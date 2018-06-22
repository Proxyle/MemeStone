package Models.Card.Minion;

import Models.Card.Card;

public class Minion extends Card {

    public Minion(String name, String context, int cost, int attackPoints, int healthPoints) {
        super(name, context, cost);
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.minionState = MinionState.AliveState;
    }

    private int attackPoints;
    private int healthPoints;
    private MinionState minionState;

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public MinionState getMinionState() {
        return minionState;
    }

    public boolean receiveDamage(int damage){
        healthPoints-=damage;
        return healthPoints > 0;
    }

}
