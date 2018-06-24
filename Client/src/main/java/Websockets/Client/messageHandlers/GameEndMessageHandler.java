package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.messages.GameEndMessage;

public class GameEndMessageHandler extends MessageHandler<GameEndMessage> {
    public GameEndMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(GameEndMessage message, String sessionId) {
        getGameClient().handleGameEnd(message.getWinner());
    }
}
