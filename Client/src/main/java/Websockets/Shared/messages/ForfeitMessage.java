package Websockets.Shared.messages;

public class ForfeitMessage {
    int lobbyId;

    public int getLobbyId() {
        return lobbyId;
    }

    public ForfeitMessage(int lobbyId) {
        this.lobbyId = lobbyId;
    }
}
