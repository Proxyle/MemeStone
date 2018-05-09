package api.model;

import java.util.Set;

public class Spell extends Card {

    public Spell(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
