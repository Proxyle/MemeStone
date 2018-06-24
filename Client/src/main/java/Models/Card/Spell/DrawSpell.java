package Models.Card.Spell;


public class DrawSpell extends Spell {

    private int drawPoints;

    public DrawSpell(String name, String context, int cost, int drawPoints) {
        super(name, context, cost);
        this.drawPoints = drawPoints;
    }

    public int getDrawPoints(){
        return drawPoints;
    }

    @Override
    public String toString() {
        if (drawPoints > 1)
            return super.toString() + ", draws " + drawPoints + " cards.";
        else
            return super.toString() + ", draws a card";
    }
}
