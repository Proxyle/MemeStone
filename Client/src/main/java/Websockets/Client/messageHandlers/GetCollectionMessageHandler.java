package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.GetCollectionMessage;
import Websockets.Shared.messages.PlayerActionFailMessage;

public class GetCollectionMessageHandler extends MessageHandler<GetCollectionMessage> {
    public GetCollectionMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(GetCollectionMessage message, String sessionId) {
        getGameClient().handleReceivedCollection(message.getCollection());
    }
}
