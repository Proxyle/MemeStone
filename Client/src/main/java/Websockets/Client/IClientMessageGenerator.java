package Websockets.Client;

import Models.Card.Card;

public interface IClientMessageGenerator {
    void registerPlayerOnServer(String name);
    void logInToServer(String name);
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
