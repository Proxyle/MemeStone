package Websockets.Client;

import Models.Card.Card;

public interface IClientMessageGenerator {
    void registerPlayerOnServer(String s, String password, String name);
    void logIn(String name, String password);
    void getCollection();
    void getLeaderboard();
    void exitGame();
    void getSettings();
    void attackCard(int attack, int defend);
    void nextTurn();
    void escapeConcede();
    void playCard(Card card, int location);

    //TODO Messages
}
