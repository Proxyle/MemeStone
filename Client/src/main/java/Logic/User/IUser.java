package Logic.User;

import Logic.Board.Board;
import Logic.Card.Collection;
import Logic.Card.Deck;
import Logic.Quest.Quest;
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
