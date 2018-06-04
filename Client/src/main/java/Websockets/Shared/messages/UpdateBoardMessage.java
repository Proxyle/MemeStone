package Websockets.Shared.messages;

import Models.Card.Card;

public class UpdateBoardMessage {
    Card[][] board;

    public Card[][] getBoard() {
        return board;
    }

    public UpdateBoardMessage(Card[][] board){
        this.board = board;
    }
}
