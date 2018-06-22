package api.model;

import api.model.resources.Collection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "minion",
        discriminatorType = DiscriminatorType.INTEGER,
        columnDefinition = "BIT"

)
@Table(name="[Card]")
@Entity
public abstract class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private Long id;

    @Column(name="[name]")
    private String name;

    @Column(name="manacost")
    private int manaCost;

    @Column(name="abilitystrength")
    private Integer abilityStrength;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Card_Ability",
        joinColumns = @JoinColumn(name = "card_id", referencedColumnName = "card_id"),
        inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "ability_id"))
    private List<Ability> abilities;

    @ManyToMany(mappedBy = "collection")
    private List<Player> players;

    public Card() { }

    public Card(Long id, String name, int manaCost, List<Ability> abilities, Integer abilityStrength){
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.abilities = abilities;
        this.abilityStrength = abilityStrength;
    }

    public Long getId() {
        return id;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public Integer getAbilityStrength() {
        return abilityStrength;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}
