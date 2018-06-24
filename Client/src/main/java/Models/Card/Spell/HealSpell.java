package Models.Card.Spell;

public class HealSpell extends Spell {

    private int healPoints;

    public HealSpell(Long id, String name, String context, int cost, int healPoints) {
        super(id, name, context, cost);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", heals " + healPoints + " health.";
    }
}
