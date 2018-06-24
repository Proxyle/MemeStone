package Logic.GameMaster;

import Models.Card.Card;
import Models.User.IPlayer;
import Websockets.Shared.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public interface IGameMaster {
    /*Login*/
    boolean logIn(String name, String password);
    void signUp(String name, String password, String email);
    void registerGameGui(IClientGUI gui);

    /*MainMenu*/
    void collection() ;
    void leaderboard();
    void exitGame();
    void getSettings();
<<<<<<< HEAD
    String[] getTaskQuests();
=======
    void getDailyQuests();
>>>>>>> 87372e4c50283964452a73fec05721bd10608253

    /*Game*/
    void attackCard(int attack, int defend);
    void playCard(Card card, int[] location);
    void nextTurn();
    void escapeConcede();

    /*Collection*/
    void addCardToDeck(int location, List<Card> collection, List<Card> deck);
    void removeCardFromDeck(int location, List<Card> collection, List<Card> deck);
    void saveDeck(ArrayList<Card> collections, ArrayList<Card> deck);
    void buyCards();

    /* User */
    IPlayer getUser();
}
