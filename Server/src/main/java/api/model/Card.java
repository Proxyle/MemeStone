package api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Inheritance
@DiscriminatorColumn(name = "card_type")
@Table(name="Card")
public abstract class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="manacost")
    private int manaCost;

    private Set<Ability> abilities;

    public Card(Long id, String name, int manaCost, Set<Ability> abilities){
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
