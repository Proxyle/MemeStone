package Logic.GameMaster;

import Models.Card.Card;
import Models.Setting.Setting;
import Models.User.User;

import java.util.ArrayList;

public interface IGameMaster {
    /*Login*/
    boolean logIn();
    boolean signUp();

    /*MainMenu*/
    boolean startGame();
    ArrayList<Card> collection() ;
    ArrayList<User> leaderboard();
    boolean exitGame();
    Setting getSettings();
    boolean changeVolume();
    boolean changeDisplay();

    /*Game*/
    Card drawCard(int amount);
    boolean healCard(Card target);
    boolean attackCard(Card target);
    Card resurrectMinion();
    boolean nextTurn();
    boolean escapeConcede();

}
