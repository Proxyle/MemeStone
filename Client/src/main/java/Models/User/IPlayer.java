package Models.User;


import Models.BoardField.*;
import Models.Card.Card;
import java.util.List;

public interface IPlayer {
    List<String> getQuests();
    int getRanking();
    String getUsername();
    String getPassword();
    String getEmail();

    List<Card> getCards();
    Board getBoard();

    List<Card> getDeck();
    List<Card> getCollection();
    int getId();
}
