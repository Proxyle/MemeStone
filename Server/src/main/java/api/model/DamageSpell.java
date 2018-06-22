package api.model;

import java.util.ArrayList;

public class DamageSpell extends Spell {
    private int damagePoints;

    public DamageSpell(Long id, String name, int manaCost, ArrayList<Ability> abilities, int abilityStrength) {
        super(id, name, manaCost, abilities, abilityStrength);
    }
}
