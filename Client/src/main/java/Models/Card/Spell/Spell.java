package Models.Card.Spell;


import Models.Card.Card;

public abstract class Spell extends Card {

    public Spell(String name, String context, int cost) {
        super(name, context, cost);
    }

    @Override
    public String toString() {
        return "Spell: " + super.toString();
    }
}
