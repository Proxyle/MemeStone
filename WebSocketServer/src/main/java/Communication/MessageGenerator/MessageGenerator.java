package Communication.MessageGenerator;

import Communication.WebSockets.IServerWebSocket;
import Messages.ServerToClient.*;
import Models.Cards.Card;
import Models.Player;

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
    public void notifyStartRound() {
        RoundStartMessage msg = new RoundStartMessage();
        serverSocket.broadcast(msg);
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
    public void notifyUpdateBoard(Card[][] board) {
        UpdateBoardMessage msg = new UpdateBoardMessage(board);
        serverSocket.broadcast(msg);
    }

    @Override
    public void notifyActionFail(String sessionId) {
        PlayerActionFailMessage msg = new PlayerActionFailMessage();
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyPlayerId(String sessionId, int id) {
        PlayerIdMessage msg = new PlayerIdMessage(id);
        serverSocket.sendTo(sessionId, msg);
    }

    @Override
    public void notifyGameEnd(String winningName) {
        GameEndMessage msg = new GameEndMessage(winningName);
        serverSocket.broadcast(msg);
    }
}
