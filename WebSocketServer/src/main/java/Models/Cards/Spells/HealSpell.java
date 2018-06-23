package Models.Cards.Spells;

import Logic.GameLogic.IGameLogic;

public class HealSpell extends Spell {

    private int healPoints;

    public HealSpell(String name, String context, int cost, int healPoints) {
        super(name, context, cost);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    @Override
    public boolean play(IGameLogic gameLogic, int[] location) {
        System.out.println("Playing a Heal spell");
        return gameLogic.damageTarget(-healPoints, location);
    }

    @Override
    public String toString() {
        return super.toString() + ", heals " + healPoints + " health.";
    }
}
