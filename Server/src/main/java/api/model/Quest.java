package api.model;

import javax.persistence.*;

@Entity
@Table(name = "Quest")
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quest_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Quest() {}

    public Quest(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
