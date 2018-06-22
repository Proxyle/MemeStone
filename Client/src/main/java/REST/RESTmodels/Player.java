package REST.RESTmodels;

import Models.Card.Card;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "[User]")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "rank")
    private int rankPoints;

    private List<Card> collection;

    public Player() { }

    public Player(Long id, String username, String password) {
        this.id = id;
        this.userName = username;
        this.password = password;
    }

    public Player(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public Player(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public List<Card> getCollection() {
        return collection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(int rankPoints) {
        this.rankPoints = rankPoints;
    }
}
