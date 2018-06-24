package Models.Card.Spell;


import Models.Card.Spell.Spell;

public class ResurrectSpell extends Spell {

    private int ressurectPoints;

    public ResurrectSpell(Long id, String name, String context, int cost, int ressurectPoints) {
        super(id, name, context, cost);
        this.ressurectPoints = ressurectPoints;
    }

    public int getRessurectPoints(){
        return ressurectPoints;
    }


    @Override
    public String toString() {
        if (ressurectPoints > 1)
            return super.toString() + ", resurrects " + ressurectPoints + " minions.";
        else
            return super.toString() + ", resurrects a minion.";
    }
}
