package Websockets.Client;

import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.*;
import Websockets.Shared.interfaces.IMessageHandlerFactory;

public class ClientMessageProcessor extends MessageProcessorBase implements IClientMessageProcessor {
    private IGameClient gameClient;

    public ClientMessageProcessor(IMessageHandlerFactory messageHandlerFactory) {
        super(messageHandlerFactory);
    }

    public void registerGameClient(IGameClient gameClient) {
        this.gameClient = gameClient;
    }

    public void processMessage(String sessionId, String type, String data) {
        String simpleType = type.split("\\.")[type.split("\\.").length -1];
        IMessageHandler handler = getMessageHandlerFactory().getHandler(simpleType, gameClient);
        handler.handleMessage(data, sessionId);
    }

    public void handleDisconnect(String sessionId) {

    }
}
