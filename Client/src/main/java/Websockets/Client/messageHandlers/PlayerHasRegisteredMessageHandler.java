package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.PlayerHasRegisteredMessage;

public class PlayerHasRegisteredMessageHandler extends MessageHandler<PlayerHasRegisteredMessage> {

    public PlayerHasRegisteredMessageHandler(IGameClient client) {
        super(client);
    }

    @Override
    public void handleMessageInternal(PlayerHasRegisteredMessage message, String sessionId) {
        getGameClient().handlePlayerRegistered(message.getPlayerName());
    }
}
