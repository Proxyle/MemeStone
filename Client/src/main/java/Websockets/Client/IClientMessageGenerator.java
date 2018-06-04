package Websockets.Client;

import Models.Card.Card;

public interface IClientMessageGenerator {
    void registerPlayerOnServer(String name);
    void logInToServer(String name);
    void startGame();
    void getCollection();
    void getLeaderboard();
    void exitGame();
    void getSettings();
    void drawCard();
    void healCard(Card card, int[] target);
    void attackCard(int attack, int defend);
    void resurrectMinion();
    void nextTurn();
    void escapeConcede();
    void playCard(Card card, int location);

    //TODO Messages
}
