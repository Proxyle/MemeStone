package Models.User;

<<<<<<< HEAD
import Models.Board.Board;
import Models.Card.Card;
import Models.Card.Collection;
import Models.Card.Deck;
import Models.Quest.Quest;
=======
import Models.Card.Card;
>>>>>>> 87372e4c50283964452a73fec05721bd10608253
import java.util.List;

public interface IPlayer {
    List<String> getQuests();
    int getRanking();
    String getUsername();
    String getPassword();
    String getEmail();
<<<<<<< HEAD
    List<Card> getCards();
    Board getBoard();
=======
    List<Card> getDeck();
    List<Card> getCollection();
>>>>>>> 87372e4c50283964452a73fec05721bd10608253
}
