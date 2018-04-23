package Models.User;

import Models.Board.Board;
import Models.Card.Collection;
import Models.Card.Deck;
import Models.Quest.Quest;
import java.util.List;

public interface IUser {
    List<Deck> getDecks();
    List<Quest> getQuests();
    String getDisplaySetting();
    int getRanking();
    String getUsername();
    String getPassword();
    String getEmail();
    Collection getCollection();
    Board getBoard();
}
