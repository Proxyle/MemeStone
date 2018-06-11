package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.interfaces.IMessageHandlerFactory;
import Websockets.Shared.messages.*;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object game){
        IGameClient gc = (IGameClient)game;{
        }
        switch(simpleType){
            case "GameEndMessage":
                return new GameEndMessageHandler(gc);
            case "PlayerActionFailMessage":
                return new PlayerActionFailMessageHandler(gc);
            case "PlayerHasRegisterdMessage":
                return new PlayerHasRegisteredMessageHandler(gc);
            case "PlayerTurnMessage":
                return new PlayerTurnMessageHandler(gc);
            case "RegistrationResultMessage":
                return new RegistrationResultMessageHandler(gc);
            case "RoundStartMessage":
                return new RoundStartMessageHandler(gc);
            case "UpdateBoardMessage":
                return new UpdateBoardMessageHandler(gc);
            case "UpdatePlayerMessage":
                return new UpdatePlayerMessageHandler(gc);
            default:
                return null;
        }
    }
}
