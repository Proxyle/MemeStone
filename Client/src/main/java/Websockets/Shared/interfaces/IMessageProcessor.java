package Websockets.Shared.interfaces;

import Logic.GameMaster.IGameMaster;

public interface IMessageProcessor {
    void processMessage(String sessionId, String type, String data);

    void handleDisconnect(String sessionId);

    void registerGame(IGameMaster game);

}
