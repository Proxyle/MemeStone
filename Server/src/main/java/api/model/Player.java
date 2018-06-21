package api.model;

import api.model.resources.Collection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[User]")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "rank")
    private int rankPoints;

    private List<Collection> collection;

    public Player() {}

    public Player(Long id, String userName, String password, String email, int rankPoints) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rankPoints = rankPoints;
        collection = new ArrayList<>();
    }

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Collection> getCollection() {
        return collection;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRankPoints() {
        return this.rankPoints;
    }

    public void setRankPoints(int rankPoints) {
        this.rankPoints = rankPoints;
    }
}