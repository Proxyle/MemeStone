package Card.Spell;

public class ResurrectSpell extends Spell {
    private int RessurectPoints;

    public ResurrectSpell(int ressurectPoints) {
        RessurectPoints = ressurectPoints;
    }

    public int getRessurectPoints() {
        return RessurectPoints;
    }
}
