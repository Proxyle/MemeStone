package Logic.GameMaster;

import Models.Card.Card;
import Websockets.Shared.interfaces.IClientGUI;

public interface IGameMaster {
    /*Login*/
    void logIn(String name, String password);
    void signUp(String name, String password);
    void registerGameGui(IClientGUI gui);

    /*MainMenu*/
    void startGame();
    void collection() ;
    void leaderboard();
    void exitGame();
    void getSettings();

    /*Game*/
    void attackCard(int attack, int defend);
    void playCard(Card card, int[] location);
    void nextTurn();
    void escapeConcede();
}
