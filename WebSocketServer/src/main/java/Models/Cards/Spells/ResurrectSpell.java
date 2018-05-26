package Models.Cards.Spells;

import Logic.GameLobby.IGameLogic;

public class ResurrectSpell extends Spell {

    private int ressurectPoints;

    public ResurrectSpell(String name, String context, int cost, int ressurectPoints) {
        super(name, context, cost);
        this.ressurectPoints = ressurectPoints;
    }

    public int getRessurectPoints(){
        return ressurectPoints;
    }

    @Override
    public boolean play(IGameLogic gameLogic, int[] location) {
        return false;
    }

    @Override
    public String toString() {
        if (ressurectPoints > 1)
            return super.toString() + ", resurrects " + ressurectPoints + " minions.";
        else
            return super.toString() + ", resurrects a minion.";
    }
}
