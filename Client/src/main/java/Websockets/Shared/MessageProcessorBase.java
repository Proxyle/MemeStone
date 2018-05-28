package Websockets.Shared;

import Logic.GameMaster.IGameMaster;
import Websockets.Shared.interfaces.IMessageHandlerFactory;
import Websockets.Shared.interfaces.IMessageProcessor;
import com.google.gson.Gson;

public abstract class MessageProcessorBase implements IMessageProcessor {
    private IGameMaster game;
    private IMessageHandlerFactory messageHandlerFactory;

    public IMessageHandlerFactory getMessageHandlerFactory() {
        return messageHandlerFactory;
    }

    public void registerGame(IGameMaster game)
    {
        this.game = game;
    }

    public abstract void processMessage(String sessionId, String type, String data);

    public abstract void handleDisconnect(String sessionId);

    private Gson gson;

    public MessageProcessorBase(IMessageHandlerFactory messageHandlerFactory)
    {
        this.messageHandlerFactory = messageHandlerFactory;
        gson = new Gson();
    }



    public Gson getGson() {
        return gson;
    }

    public IGameMaster getGame()
    {
        return game;
    }

}
