package Messages.ServerToClient;

import Models.Board;
import Models.Cards.Card;
import Models.Cards.Minion;

public class UpdateBoardMessage {
    Board board;

    public Board getBoard() {
        return board;
    }

    public UpdateBoardMessage(Board board){
        this.board = board;
    }
}
