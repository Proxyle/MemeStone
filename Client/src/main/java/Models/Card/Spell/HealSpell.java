package Models.Card.Spell;

public class HealSpell extends Spell {
    private int healPoints;



    public HealSpell(int healPoints) {

        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }
}
