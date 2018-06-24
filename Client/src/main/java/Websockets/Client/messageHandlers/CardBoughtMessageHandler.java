package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.messages.CardBoughtMessage;

public class CardBoughtMessageHandler extends MessageHandler<CardBoughtMessage> {

    public CardBoughtMessageHandler(IGameClient client) {
        super(client);
    }

    @Override
    public void handleMessageInternal(CardBoughtMessage message, String sessionId) {
        getGameClient().handleCardBought();
    }
}
