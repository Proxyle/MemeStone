package Websockets.Shared.messages;

public class BuyCardMessage {
    int playerId;

    public int getPlayerId() {
        return playerId;
    }

    public BuyCardMessage(int playerId) {
        this.playerId = playerId;
    }
}