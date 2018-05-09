package api.model;

import java.util.Set;

public class Minion extends Card {
    private int attackPoints;
    private int healthPoints;

    public Minion(Long id, String name, int manaCost, Set<Ability> abilities) {
        super(id, name, manaCost, abilities);
    }
}
