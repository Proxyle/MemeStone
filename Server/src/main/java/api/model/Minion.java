package api.model;

import javax.persistence.*;
import java.util.List;

@DiscriminatorValue("1")
@Entity
public class Minion extends Card {
    @Column(name = "attackpoints")
    private Integer attackPoints;

    @Column(name = "healthpoints")
    private Integer healthPoints;

    public Minion() { super(); }

    public Minion(Long id, String name, int manaCost, List<Ability> abilities, String imageUrl, Integer abilityStrength) {
        super(id, name, manaCost, abilities, imageUrl, abilityStrength);
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }
}
