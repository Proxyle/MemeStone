package Models.User;

import Models.Board.Board;
import Models.Card.Collection;
import Models.Card.Deck;
import Models.Quest.Quest;

import java.util.List;

public class User {
    private List<Deck> decks;
    private List<Quest> quests;
    private String displaySetting;
    private int ranking;
    private String username;
    private String password;
    private String email;
    private Collection collection;
    private Board board;



    public User(List<Deck> decks, List<Quest> quests, String displaySetting, int ranking, String username, String password, String email, Collection collection) {
        this.decks = decks;
        this.quests = quests;
        this.displaySetting = displaySetting;
        this.ranking = ranking;
        this.username = username;
        this.password = password;
        this.email = email;
        this.collection = collection;
    }

    public User() {
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public String getDisplaySetting() {
        return displaySetting;
    }

    public int getRanking() {
        return ranking;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Collection getCollection() {
        return collection;
    }

    public Board getBoard() {
        return board;
    }
}
