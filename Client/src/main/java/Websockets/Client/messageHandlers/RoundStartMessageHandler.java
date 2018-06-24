package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.RoundStartMessage;

public class RoundStartMessageHandler extends MessageHandler<RoundStartMessage> {
    public RoundStartMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(RoundStartMessage message, String sessionId) {
        getGameClient().handleRoundStart(message.getLobbyId());
    }
}
