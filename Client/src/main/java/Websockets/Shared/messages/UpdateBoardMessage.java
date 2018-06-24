package Websockets.Shared.messages;

import Models.Board;
import Models.Card.Card;

public class UpdateBoardMessage {
    Board board;

    public Board getBoard() {
        return board;
    }

    public UpdateBoardMessage(Board board){
        this.board = board;
    }
}
