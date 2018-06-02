package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.interfaces.IMessageHandlerFactory;

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
                gc.handlePlayerRegistrationResponse(true);
                break;
            case "PlayerIdMessage":
                //TODO implement message;
                break;
            case "PlayerTurnMessage":
                //TODO implement message;
                break;
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
