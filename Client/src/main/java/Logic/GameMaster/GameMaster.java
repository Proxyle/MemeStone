package Logic.GameMaster;

import Models.Board.IBoard;
import Models.Card.Card;
import Models.User.IUser;
import Models.Setting.Setting;

public class GameMaster implements IGameMaster {
    private IBoard board;
    private IUser user;

    public IUser getUser() {
        return user;
    }

    public Card drawCard(int ammount) {
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

    public Setting getSettings() {
        return null;
    }

    public boolean changeVolume() {
        return false;
    }

    public boolean changeDisplay() {
        return false;
    }
}
