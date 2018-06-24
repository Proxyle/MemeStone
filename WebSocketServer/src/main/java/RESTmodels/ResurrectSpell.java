package RESTmodels;

import RESTmodels.Ability;
import RESTmodels.Spell;

import java.util.ArrayList;

public class ResurrectSpell extends Spell {
    private int ressurectPoints;

    public ResurrectSpell(Long id, String name, int manaCost, ArrayList<Ability> abilities, int abilityStrength) {
        super(id, name, manaCost, abilities, abilityStrength);
    }
}