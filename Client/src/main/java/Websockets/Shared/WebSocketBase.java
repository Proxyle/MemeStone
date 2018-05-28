package Websockets.Shared;

import Websockets.Shared.interfaces.IEncapsulatingMessageGenerator;
import Websockets.Shared.interfaces.IMessageProcessor;
import Websockets.Shared.interfaces.IWebSocket;
import com.google.gson.Gson;

public abstract class WebSocketBase implements IWebSocket {
    private IMessageProcessor handler;

    public IEncapsulatingMessageGenerator getEncapsulatingMessageGenerator() {
        return encapsulatingMessageGenerator;
    }

    private IEncapsulatingMessageGenerator encapsulatingMessageGenerator = new EncapsulatingMessageGenerator();

    private Gson gson;

    public WebSocketBase()
    {
        gson = new Gson();
    }

    public void setMessageHandler(IMessageProcessor handler)
    {
        this.handler = handler;
    }

    public abstract void start();

    public abstract void stop();

    public IMessageProcessor getHandler() {
        return handler;
    }

    public Gson getGson() {
        return gson;
    }

}
