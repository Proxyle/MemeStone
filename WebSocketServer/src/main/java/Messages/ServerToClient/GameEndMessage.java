package Messages.ServerToClient;

public class GameEndMessage {
    String winner;

    public String getWinner() {
        return winner;
    }

    public GameEndMessage(String winner){
        this.winner = winner;
    }
}
