package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.PlayerActionFailMessage;

public class PlayerActionFailMessageHandler extends MessageHandler<PlayerActionFailMessage> {
    public PlayerActionFailMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(PlayerActionFailMessage message, String sessionId) {
        getGameClient().handlePlayerActionFail();
    }
}
