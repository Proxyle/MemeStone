package Models.Cards.Spells;

import Logic.GameLobby.IGameLogic;

public class DamageSpell extends Spell {

    private int damagePoints;

    public DamageSpell(String name, String context, int cost, int damagePoints) {
        super(name, context, cost);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    @Override
    public boolean play(IGameLogic gameLogic, int[] location) {
        System.out.println("Playing a Damage Spell");
        return gameLogic.damageTarget(damagePoints, location);
    }

    @Override
    public String toString() {
        return super.toString() + ", deals " + damagePoints + " damage.";
    }
}
