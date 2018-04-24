package model;

import model.enums.Rarity;

import javax.persistence.*;

@Entity
@Table(name="cards") // Not for sure
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cardId")
    private Long id;
    @Column(name="name")
    private String name;
    private String context;
    private int cost;
    private Rarity rarity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
