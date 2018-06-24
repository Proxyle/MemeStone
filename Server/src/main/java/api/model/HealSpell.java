package api.model;

import java.util.ArrayList;

public class HealSpell extends Spell {
    private int healPoints;

    public HealSpell(Long id, String name, int manaCost, ArrayList<Ability> abilities, int abilityStrength) {
        super(id, name, manaCost, abilities, abilityStrength);
    }
}
