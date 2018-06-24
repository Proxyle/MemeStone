package Models.Card.Minion;

import Models.Card.Card;

public class Minion extends Card {

    boolean Attacked = false;

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

    public Minion receiveDamage(int damage){
        healthPoints-=damage;
        if (healthPoints > 1)
            return null;
        return this;
    }

    @Override
    public String toString() {
        return "Minion: " + super.toString() + ", attack points: " + attackPoints + ", health points: " + healthPoints;
    }

    public void newTurn(){
        Attacked = false;
    }
    public boolean hasAttacked(){return Attacked;}
}

