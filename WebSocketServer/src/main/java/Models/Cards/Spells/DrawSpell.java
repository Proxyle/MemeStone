package Models.Cards.Spells;

import Logic.GameLogic.IGameLogic;

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
    public boolean play(IGameLogic gameLogic, int[] location) {
        System.out.println("Playing a Draw spell");
        gameLogic.drawCard(drawPoints);
        return true;
    }

    @Override
    public String toString() {
        if (drawPoints > 1)
            return super.toString() + ", draws " + drawPoints + " cards.";
        else
            return super.toString() + ", draws a card";
    }
}
