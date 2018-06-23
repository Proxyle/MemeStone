package Messages.ServerToClient;

public class RoundStartMessage {
    int lobbyId;

    public int getLobbyId() {
        return lobbyId;
    }

    public RoundStartMessage(int lobbyId){
        this.lobbyId = lobbyId;
    }
}
