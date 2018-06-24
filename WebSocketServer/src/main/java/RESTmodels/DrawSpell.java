package RESTmodels;

import RESTmodels.Ability;
import RESTmodels.Spell;

import java.util.ArrayList;

public class DrawSpell extends Spell {
    private int drawPoints;

    public DrawSpell(Long id, String name, int manaCost, ArrayList<Ability> abilities, int abilityStrength) {
        super(id, name, manaCost, abilities, abilityStrength);
    }
}
