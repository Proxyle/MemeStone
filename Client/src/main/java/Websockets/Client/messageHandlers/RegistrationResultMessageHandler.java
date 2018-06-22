package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.RegistrationResultMessage;

public class RegistrationResultMessageHandler extends MessageHandler<RegistrationResultMessage> {
    public RegistrationResultMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(RegistrationResultMessage message, String sessionId) {
        getGameClient().handlePlayerRegistrationResponse(message.isResult());
    }
}
