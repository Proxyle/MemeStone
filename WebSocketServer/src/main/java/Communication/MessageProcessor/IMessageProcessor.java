package Communication.MessageProcessor;

import Logic.GameLogic.IGameLogic;
import Logic.GameServer.IGameServerMain;

public interface IMessageProcessor {
    void processMessage(String sessionId, String messageType, String messageData);

    void handleDisconnect(String id);

    void connectMainServer(IGameServerMain gameServer);
}
