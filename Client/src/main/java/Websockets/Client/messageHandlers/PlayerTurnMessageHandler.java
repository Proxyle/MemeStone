package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.PlayerTurnMessage;

public class PlayerTurnMessageHandler extends MessageHandler<PlayerTurnMessage> {
    public PlayerTurnMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(PlayerTurnMessage message, String sessionId) {
        getGameClient().handlePlayerTurn(message.)
    }
}
