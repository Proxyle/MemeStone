package Communication.MessageGenerator;

import Communication.WebSockets.IServerWebSocket;
import Messages.ServerToClient.*;
import Models.Board;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Player;

import java.util.List;

public class MessageGenerator implements IMessageGenerator {

    private IServerWebSocket serverSocket;

    public MessageGenerator(IServerWebSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void notifyRegisterResult(String sessionId, boolean success) {
        RegistrationResultMessage msg = new RegistrationResultMessage(success);
        serverSocket.sendTo(sessionId, msg);

    }

    @Override
    public void notifyPlayerAdded(String sessionId, String userName) {
        PlayerHasRegisteredMessage msg = new PlayerHasRegisteredMessage(userName);
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyStartRound(List<String> sessionIds, int lobbyId) {
        RoundStartMessage msg = new RoundStartMessage(lobbyId);
        serverSocket.sendToGroup((String[])sessionIds.toArray(), msg);
    }

    @Override
    public void notifyPlayerTurn(String sessionId) {
        PlayerTurnMessage msg = new PlayerTurnMessage();
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyUpdatePlayer(String sessionId, Player player) {
        UpdatePlayerMessage msg = new UpdatePlayerMessage(player);
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyUpdateBoard(String sessionId, Board board) {
        UpdateBoardMessage msg = new UpdateBoardMessage(board);
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyActionFail(String sessionId) {
        PlayerActionFailMessage msg = new PlayerActionFailMessage();
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyGameEnd(List<String> sessionIds, String winningName) {
        GameEndMessage msg = new GameEndMessage(winningName);
        serverSocket.sendToGroup((String[])sessionIds.toArray(), msg);
    }
}
