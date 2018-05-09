package api.model;

import java.util.Set;

public class HealSpell extends Spell {
    private int healPoints;

    public HealSpell(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
