package Websockets.Shared;

import Logic.GameMaster.IGameMaster;
import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IMessageHandler;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class MessageHandler<T> implements IMessageHandler {
    private IGameMaster game;
    private Gson gson;
    private IGameClient gameClient;

    public IGameClient getGameClient() {
        return gameClient;
    }

    public MessageHandler(IGameClient client)
    {
        this.gameClient = client;
        gson = new Gson();
    }

    public MessageHandler(IGameMaster game)
    {
        this.game = game;
        gson = new Gson();
    }

    public void handleMessage(String data, String sessionId)
    {
        Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T msg = gson.fromJson(data, type);
        handleMessageInternal(msg, sessionId);
    }

    public abstract void handleMessageInternal(T message, String sessionId);

    public IGameMaster getGame()
    {
        return game;
    }

}
