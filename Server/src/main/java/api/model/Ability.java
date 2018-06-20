package api.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "Ability")
@Entity
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ability_id")
    private Long id;

    @Column(name="[name]")
    private String name;

    @ManyToMany(mappedBy = "abilities")
    private List<Card> cards;

    public Ability() { }

    public Ability(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
