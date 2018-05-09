package api.model;

import java.util.Set;

public class DamageSpell extends Spell {
    private int damagePoints;

    public DamageSpell(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
