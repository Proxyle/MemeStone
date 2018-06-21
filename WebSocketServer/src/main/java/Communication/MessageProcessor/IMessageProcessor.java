package Communication.MessageProcessor;

import Logic.GameLobby.IGameLogic;

public interface IMessageProcessor {
    void processMessage(String sessionId, String messageType, String messageData);

    void handleDisconnect(String id);

    void connectLobby(IGameLogic gameLobby);
}
