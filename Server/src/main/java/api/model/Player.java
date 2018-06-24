package api.model;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_Card",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    )
    private List<Card> collection;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Deck",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    )
    private List<Card> deck;

    public Player() {}

    public Player(Long id, String userName, String password, String email, int rankPoints) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rankPoints = rankPoints;
        collection = new ArrayList<>();
    }

    public void addCardToCollection(Card card) {
        collection.add(card);
        card.addPlayerToCollection(this);
    }

    public void updateDeck(List<Card> deck) {
        deck.clear();
        this.deck = deck;
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

    public List<Card> getCollection() {
        return collection;
    }

    public void setCollection(List<Card> collection) {
        this.collection = collection;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
