package Messages.ServerToClient;

import Models.Cards.Card;
import Models.Cards.Minion;

public class UpdateBoardMessage {
    Minion[][] board;

    public Minion[][] getBoard() {
        return board;
    }

    public UpdateBoardMessage(Minion[][] board){
        this.board = board;
    }
}
