package Models.Cards;

import Logic.GameLogic.IGameLogic;
import Models.FieldBuff;

public class Minion extends Card {

    boolean attacked = false;

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

    public Minion includeFieldBuff(FieldBuff fieldBuff){
        switch(fieldBuff){
            case n1Health:
                return new Minion(getName(), getContext(), getCost(), attackPoints, healthPoints-1);
            case p1Health:
                return new Minion(getName(), getContext(), getCost(), attackPoints, healthPoints+1);
            case p2Health:
                return new Minion(getName(), getContext(), getCost(), attackPoints, healthPoints+2);
            case p3Health:
                return new Minion(getName(), getContext(), getCost(), attackPoints, healthPoints-3);
            case n1Dmg:
                return new Minion(getName(), getContext(), getCost(), attackPoints-1, healthPoints);
            case p1Dmg:
                return new Minion(getName(), getContext(), getCost(), attackPoints+1, healthPoints);
            case p2Dmg:
                return new Minion(getName(), getContext(), getCost(), attackPoints+2, healthPoints);
            case p3Dmg:
                return new Minion(getName(), getContext(), getCost(), attackPoints+3, healthPoints);
            default:
                return null;
        }
    }


    @Override
    public boolean play(IGameLogic gameLogic, int[] location) {
        System.out.println("Playing a Minion");
        return gameLogic.placeMinion(location[1], this);
    }

    @Override
    public String toString() {
        return "Minion: " + super.toString() + ", attack points: " + attackPoints + ", health points: " + healthPoints;
    }

    public void newTurn(){
        attacked = false;
    }
    public boolean hasAttacked(){return attacked;}
    public void setAttacked() {attacked = true;}
}
