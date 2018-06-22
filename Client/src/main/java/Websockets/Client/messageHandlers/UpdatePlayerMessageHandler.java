package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.UpdatePlayerMessage;

public class UpdatePlayerMessageHandler extends MessageHandler<UpdatePlayerMessage> {
    public UpdatePlayerMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(UpdatePlayerMessage message, String sessionId) {
        getGameClient().handleUpdatePlayer(message.getPlayer());
    }
}
