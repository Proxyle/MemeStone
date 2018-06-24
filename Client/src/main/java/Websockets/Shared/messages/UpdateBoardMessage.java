package Websockets.Shared.messages;

import Models.BoardField.*;

public class UpdateBoardMessage {
    Board board;

    public Board getBoard() {
        return board;
    }

    public UpdateBoardMessage(Board board){
        this.board = board;
    }
}
