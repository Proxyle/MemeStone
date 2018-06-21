package Logic.GameMaster;

import Models.Card.Card;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.ArrayList;
import java.util.List;

public interface IGameMaster {
    /*Login*/
    void logIn(String name, String password);
    void signUp(String name, String password, String email);
    void registerGameGui(IClientGUI gui);

    /*MainMenu*/
    void collection() ;
    void leaderboard();
    void exitGame();
    void getSettings();
    String[] getDailyQuests();

    /*Game*/
    void attackCard(int attack, int defend);
    void playCard(Card card, int[] location);
    void nextTurn();
    void escapeConcede();

    /*Collection*/
    void setCollection(List<Card> collecton);
    void addCardToDeck(int location, List<Card> collection, List<Card> deck);
    void removeCardFromDeck(int location, List<Card> collection, List<Card> deck);
    void saveDeck(ArrayList<Card> collections, ArrayList<Card> deck);
    void buyCards();

}
