package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.interfaces.IMessageHandlerFactory;
import Websockets.Shared.messages.PlayerHasRegisteredMessage;
import Websockets.Shared.messages.PlayerTurnMessage;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object game){
        IGameClient gc = (IGameClient)game;{
        }
        switch(simpleType){
            case "GameEndMessage":
                //TODO implement message;
                break;
            case "PlayerActionFailMessage":
                //TODO implement message;
                break;
            case "PlayerHasRegisterdMessage":
                return new PlayerHasRegisteredMessageHandler(gc);
            case "PlayerTurnMessage":
                return new PlayerTurnMessageHandler(gc);
            case "RegistrationResultMessage":
                //TODO implement message;
                break;
            case "RoundStartMessage":
                //TODO implement message;
                break;
            case "UpdateBoardMessage":
                //TODO implement message;
                break;
            case "UpdatePlayerMessage":
                //TODO implement message;
                break;
            default:
                return null;
        }
        return null;
    }
}
