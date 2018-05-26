package Communication.MessageHandlers;

import Logic.GameLobby.IGameLogic;
import com.google.gson.Gson;

public interface IMessageHandler {
    void setGameLogic(IGameLogic gameLogic);
    void handleMessage(String sessionId, String data, String simpleType, Gson gson);
}
