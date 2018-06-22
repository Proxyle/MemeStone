package Communication.MessageProcessor;

import Communication.MessageHandlers.IMessageHandler;
import Logic.GameLobby.IGameLogic;
import com.google.gson.Gson;

public class MessageProcessor implements IMessageProcessor {

    IGameLogic gameLogic;

    private IMessageHandler handler;

    public IMessageHandler getMessageHandler() {
        return handler;
    }

    public void processMessage(String sessionId, String type, String data){
        String simpleType = type.split("\\.")[type.split("\\.").length - 1];

        handler.handleMessage(sessionId, data, simpleType, gson);
    }

    public void handleDisconnect(String sessionId){

    }

    public void connectLobby(IGameLogic gameLogic) {
        this.gameLogic = gameLogic;
        handler.setGameLogic(gameLogic);
    }

    private Gson gson;

    public MessageProcessor(IMessageHandler handler)
    {
        this.handler = handler;
        gson = new Gson();
    }

    public Gson getGson() {
        return gson;
    }
}
