package model;

import model.enums.Rarity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
@DiscriminatorColumn(name = "card_type")
@Table(name="cards") // Not for sure
public abstract class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cardId")
    private Long id;
    @NotNull
    @Column(name="name")
    private String name;
    //@NotNull
    //@Column(name="context")
    private String context;
    @NotNull
    @Column(name="")
    private int manaCost;
    @NotNull
    @Column(name="")
    private Rarity rarity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
