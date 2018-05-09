package api.model;

import java.util.Set;

public class DrawSpell extends Spell {
    private int drawPoints;

    public DrawSpell(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
