package Logic.Card.Spell;

public class ResurrectSpell extends Spell {
    private int ResurrectPoints;

    public ResurrectSpell(int resurrectPoints) {
        ResurrectPoints = resurrectPoints;
    }

    public int getResurrectPoints() {
        return ResurrectPoints;
    }
}
