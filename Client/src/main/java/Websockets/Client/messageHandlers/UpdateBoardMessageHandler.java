package Websockets.Client.messageHandlers;

import Websockets.Client.IGameClient;
import Websockets.Shared.MessageHandler;
import Websockets.Shared.interfaces.IMessageHandler;
import Websockets.Shared.messages.UpdateBoardMessage;

public class UpdateBoardMessageHandler extends MessageHandler<UpdateBoardMessage> {
    public UpdateBoardMessageHandler(IGameClient gc) {
        super(gc);
    }

    @Override
    public void handleMessageInternal(UpdateBoardMessage message, String sessionId) {
        getGameClient().handleUpdateBoard(message.getBoard());
    }
}
