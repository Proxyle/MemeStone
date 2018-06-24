package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.messages.GetCollectionMessage;

public class GetCollectionMessageHandler extends MessageHandler<GetCollectionMessage> {
    public GetCollectionMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(GetCollectionMessage message, String sessionId) {
        getGameClient().handleReceivedCollection(message.getCollection());
    }
}
