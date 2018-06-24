package Models.Card.Spell;


import Models.Card.Card;

public abstract class Spell extends Card {

    public Spell(Long id, String name, String context, int cost) {
        super(id, name, context, cost);
    }

    @Override
    public String toString() {
        return "Spell: " + super.toString();
    }
}
