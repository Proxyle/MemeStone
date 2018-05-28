package Logic.GameMaster;

import Models.Board.IBoard;
import Models.Card.Card;
import Models.User.IUser;
import Models.Setting.Setting;
import Models.User.User;

import java.util.ArrayList;

public class GameMaster implements IGameMaster {
    private IBoard board;
    private IUser user;

    /*Login*/
    public boolean logIn() {
        return false;
    }

    public boolean signUp() {
        return false;
    }

    /*Menu*/
    public boolean startGame() {
        return false;
    }

    public ArrayList<Card> collection() {
        return null;
    }

    public ArrayList<User> leaderboard() {
        return null;
    }

    public boolean exitGame() {
        return false;
    }

    public Setting getSettings() {
        return null;
    }

    public boolean changeVolume() {
        return false;
    }

    public boolean changeDisplay() {
        return false;
    }

    /*Game*/
    public Card drawCard(int amount) {
        return null;
    }

    public boolean healCard(Card target) {
        return false;
    }

    public boolean attackCard(Card target) {
        return false;
    }

    public Card resurrectMinion() {
        return null;
    }

    public boolean nextTurn() {
        return false;
    }

    public boolean escapeConcede() {
        return false;
    }
}
