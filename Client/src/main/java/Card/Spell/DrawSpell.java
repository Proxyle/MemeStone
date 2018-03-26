package Card.Spell;

public class DrawSpell extends Spell {
    private int drawPoints;

    public DrawSpell(int drawPoints) {
        this.drawPoints = drawPoints;
    }

    public int getDrawPoints() {
        return drawPoints;
    }
}
