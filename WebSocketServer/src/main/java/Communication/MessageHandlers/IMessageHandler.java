package Communication.MessageHandlers;

import Logic.GameLogic.IGameLogic;
import Logic.GameServer.IGameServerMain;
import com.google.gson.Gson;

public interface IMessageHandler {
    void setGameServer(IGameServerMain gameServer);
    void handleMessage(String sessionId, String data, String simpleType, Gson gson);
}
