package Card.Spell;

public class DamageSpell extends Spell {
    private int damagePoints;

    public DamageSpell(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
}
