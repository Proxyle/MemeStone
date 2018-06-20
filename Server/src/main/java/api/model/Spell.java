package api.model;

import javax.persistence.*;
import java.util.List;

@DiscriminatorValue("0")
@Entity
public class Spell extends Card {
    public Spell() { super(); }

    public Spell(Long id, String name, int manaCost, List<Ability> abilities, String imageUrl, Integer abilityStrength) {
        super(id, name, manaCost, abilities, imageUrl, abilityStrength);
    }
}
