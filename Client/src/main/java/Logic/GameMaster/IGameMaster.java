package Logic.GameMaster;

import Models.Card.Card;
import Models.Setting.Setting;
import Models.User.User;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.ArrayList;

public interface IGameMaster {
    /*Login*/
    void logIn(String name);
    void signUp(String name);
    void registerGameGui(IClientGUI gui);

    /*MainMenu*/
    void startGame();
    void collection() ;
    void leaderboard();
    void exitGame();
    void getSettings();
    void changeVolume();
    void changeDisplay();

    /*Game*/
    void drawCard(int amount);
    void healCard(Card card, int[] target);
    void attackCard(int attack, int defend);
    void resurrectMinion();
    void nextTurn();
    void escapeConcede();
}