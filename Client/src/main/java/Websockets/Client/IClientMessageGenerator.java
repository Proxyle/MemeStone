package Websockets.Client;


import Models.Card.Card;
import Models.User.Player;

import java.util.ArrayList;

public interface IClientMessageGenerator {
    void registerPlayerOnServer(String s, String password, String name);
    Player logIn(String name, String password);
    void getCollection();
    void getLeaderboard();
    void exitGame();
    void getSettings();
    void attackCard(int attack, int defend);
    void nextTurn();
    void escapeConcede();
    void playCard(Card card, int[] location);

    void saveDeck(ArrayList<Card> collection, ArrayList<Card> deck);

    void buyCards();

    void getDailyQuest();

    //TODO Messages
}
