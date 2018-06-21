package Models;

import java.util.List;

public class User {

    private String username;
    private String password;
    private String email;
    private Collection collection;
    private List<Deck> decks;
    private int ranking;

    public User(String username, String password, String email, Collection collection, List<Deck> decks, int ranking) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.collection = collection;
        this.decks = decks;
        this.ranking = ranking;
    }
}
