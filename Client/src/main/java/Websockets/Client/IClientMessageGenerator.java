package Websockets.Client;


import Models.Card.Card;
import Models.User.Player;

import java.util.ArrayList;

public interface IClientMessageGenerator {
    void registerPlayerOnServer(String s, String password, String name);
    Player logIn(String name, String password);
    void getCollection();
    void getLeaderboard();
    void exitGame(int lobbyId);
    void getSettings();
    void attackCard(int lobbyId, int attack, int defend);
    void nextTurn(int lobbyId);
    void escapeConcede(int lobbyId);
    void playCard(int lobbyId, Card card, int[] location);

    void saveDeck(ArrayList<Card> collection, ArrayList<Card> deck);

    void buyCards(int id);

    void getDailyQuest();

    //TODO Messages
}
