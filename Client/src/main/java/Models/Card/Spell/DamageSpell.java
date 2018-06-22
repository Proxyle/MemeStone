package Models.Card.Spell;


import Models.Card.Spell.Spell;

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
    public String toString() {
        return super.toString() + ", deals " + damagePoints + " damage.";
    }
}
