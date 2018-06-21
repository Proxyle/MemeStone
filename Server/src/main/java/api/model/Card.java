package api.model;

import api.model.resources.Collection;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Minion.class, name = "minion"),
        @JsonSubTypes.Type(value = Spell.class, name = "spell")
})*/
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

    @Column(name="imageURL")
    private String imageUrl;

    @Column(name="abilitystrength")
    private Integer abilityStrength;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Card_Ability",
        joinColumns = @JoinColumn(name = "card_id", referencedColumnName = "card_id"),
        inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "ability_id"))
    private List<Ability> abilities;

    private List<Collection> collection;

    public Card() { }

    public Card(Long id, String name, int manaCost, List<Ability> abilities, String imageUrl, Integer abilityStrength){
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.abilities = abilities;
        this.imageUrl = imageUrl;
        this.abilityStrength = abilityStrength;
        collection = new ArrayList<>();
    }

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Collection> getCollection() {
        return collection;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getAbilityStrength() {
        return abilityStrength;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}