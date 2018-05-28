package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.interfaces.IMessageHandlerFactory;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object game){
        IGameClient gc = (IGameClient)game;

        switch(simpleType){
            case "eeeeeee":
                //TODO implement message;
            default:
                return null;
        }
    }
}
