package api.model;

import java.util.Set;

public class ResurrectSpell extends Spell {
    private int ressurectPoints;

    public ResurrectSpell(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
