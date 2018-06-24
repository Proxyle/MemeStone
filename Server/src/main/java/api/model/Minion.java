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

    public Minion(Long id, String name, int manaCost, List<Ability> abilities, Integer abilityStrength) {
        super(id, name, manaCost, abilities, abilityStrength);
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }
}
