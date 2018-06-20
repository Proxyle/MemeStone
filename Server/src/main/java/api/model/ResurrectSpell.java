package api.model;

import java.util.ArrayList;

public class ResurrectSpell extends Spell {
    private int ressurectPoints;

    public ResurrectSpell(Long id, String name, int manaCost, ArrayList<Ability> abilities, String imageUrl, int abilityStrength) {
        super(id, name, manaCost, abilities, imageUrl, abilityStrength);
    }
}
