package Communication.MessageProcessor;

import Communication.MessageHandlers.IMessageHandler;
import Logic.GameLogic.IGameLogic;
import Logic.GameServer.IGameServerMain;
import com.google.gson.Gson;

public class MessageProcessor implements IMessageProcessor {

    IGameServerMain gameServer;

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

    public void connectMainServer(IGameServerMain gameServer) {
        this.gameServer = gameServer;
        handler.setGameServer(gameServer);
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
