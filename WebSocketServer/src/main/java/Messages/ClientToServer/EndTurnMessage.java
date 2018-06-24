package Messages.ClientToServer;

public class EndTurnMessage {
    int lobbyId;

    public int getLobbyId() {
        return lobbyId;
    }

    public EndTurnMessage(int lobbyId){
        this.lobbyId = lobbyId;
    }
}
